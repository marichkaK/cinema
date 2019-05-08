var app = angular.module('app',['ui.router','ngStorage', 'ngTable']);

app.constant('urls', {
    BASE: 'http://localhost:8080/ui/',
    USER_SERVICE_API : 'http://localhost:8080/ui/api/user/',
    MOVIE_SERVICE_API : 'http://localhost:8080/ui/api/movies/'
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

