package com.websystique.springboot.service;

import com.websystique.springboot.model.Movie;
import com.websystique.springboot.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("movieService")
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie findById(Long id) {
        return movieRepository.findOne(id);
    }

    public Movie findByName(String name) {
        return movieRepository.findByName(name);
    }

    public void deleteMovieById(Long id) {
        movieRepository.delete(id);
    }

    public void deleteAllMovies() {
        movieRepository.deleteAll();
    }

    public List<Movie> findAllMovie() {
        return movieRepository.findAll();
    }

    public boolean isMovieExist(Movie movie) {
        return findByName(movie.getName()) != null;
    }

}
