package com.websystique.springboot.api.service;

import com.websystique.springboot.api.model.Movie;
import com.websystique.springboot.api.repository.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

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
