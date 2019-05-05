var app = angular.module('app',['ui.router','ngStorage', 'ngTable']);

app.constant('urls', {
    BASE: 'http://localhost:8080/',
    USER_SERVICE_API : 'http://localhost:8080/api/user/',
    MOVIE_SERVICE_API : 'http://localhost:8080/api/movies/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/MovieList.html',
                controller:'MovieController',
                controllerAs:'ctrl'
            })
            .state('home1', {
                url: '/statistics',
                templateUrl: 'partials/MovieStatistic.html',
                controller:'MovieController'
            });
        $urlRouterProvider.otherwise('/');
    }]);

