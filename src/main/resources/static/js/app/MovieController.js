'use strict';

app.filter('customUserDateFilter', function($filter) {
       return function(values, dateString) {
        var filtered = [];

         if(typeof values != 'undefined' && typeof dateString != 'undefined') {
           angular.forEach(values, function(value) {
               if($filter('date')(value.startDate).indexOf(dateString) >= 0) {
                 filtered.push(value);
               }
             });
         }

         return filtered;
       }
   }).controller('MovieController', function(MovieService1, $scope, $filter, ngTableParams) {
    MovieService1.getAllMovies(
        function (response) {
            var data = response.data;
            $scope.tableParams = new ngTableParams({
                    page: 1,            // show first page
                    count: 10,          // count per page
                }, {
                    total: data.length, // length of data
                    getData: function($defer, params) {
                        // use build-in angular filter
                        var filters = params.filter();
                        var tempDateFilter;

                        var orderedData = params.sorting() ?
                                        $filter('orderBy')(data, params.orderBy()) :
                                        data;

                        if(filters) {
                          if(filters.startDate) {
                            orderedData = $filter('customUserDateFilter')(orderedData, filters.startDate);
                            tempDateFilter = filters.startDate;
                            delete filters.startDate;
                          }
                          orderedData = $filter('filter')(orderedData, filters);
                          filters.startDate = tempDateFilter;
                        }

                        $scope.users = orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count());

                        params.total(orderedData.length); // set total for recalc pagination
                        $defer.resolve($scope.users);
                    }
                });
    });

    MovieService1.getMoviesByDate(
        function (response){
            $scope.movies = response.data;
        }
    )

    $scope.getTheMostSalableMovies = function(){
     MovieService1.getTheMostSalableMovies($scope.age, $scope.topMoviesNum,
            function (response){
                $scope.moviesByAge = response.data;
            }
        )
    }

});