package com.websystique.springboot.api.service;

import com.websystique.springboot.api.dto.MovieModelDto;
import com.websystique.springboot.api.model.Genre;
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
    private final GenreService genreService;

    @Autowired
    public MovieService(MovieRepository movieRepository, GenreService genreService) {
        this.movieRepository = movieRepository;
        this.genreService = genreService;
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(MovieModelDto movieDto) {
        Movie movie = movieDto.toMovie();

        List<Genre> genres = genreService.findByNames(movieDto.getGenres());
        movie.setGenres(genres);

        return movieRepository.save(movie);
    }

    public Movie getMovie(Long id) {
        return movieRepository.getOne(id);
    }
}
