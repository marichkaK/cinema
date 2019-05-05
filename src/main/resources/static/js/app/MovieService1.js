'use strict';

angular.module('app').factory('MovieService1',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllMovies: loadAllMovies,
                getAllMovies: getAllMovies,
                getMovie: getMovie,
                getMoviesByDate: getMoviesByDate,
                getTheMostSalableMovies: getTheMostSalableMovies
            };

            return factory;

            function loadAllMovies() {
                console.log('Fetching all movies');
                var deferred = $q.defer();
                $http.get(urls.MOVIE_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all users');
                            $localStorage.movies = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading users');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllMovies(success, fail) {
                return $http.get(urls.MOVIE_SERVICE_API).then(success, fail);
            }

            function getMoviesByDate(success, fail) {
                return $http.get(urls.MOVIE_SERVICE_API + '/filter').then(success, fail);
            }

            function getMovie(id) {
                console.log('Fetching User with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.MOVIE_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully User with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading user with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }


            function getTheMostSalableMovies(age, topMoviesNum, success, fail) {
                return $http.get('api/tickets?age='+age+'&topNumberOfMovies='+topMoviesNum).then(success, fail);
            }

        }
    ]);