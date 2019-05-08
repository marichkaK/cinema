package com.websystique.springboot.ui.controller;

import com.websystique.springboot.ui.dto.MovieDto;
import com.websystique.springboot.ui.service.MovieService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    private final MovieService movieService; //Service which will do all data retrieval/manipulation work

    @Autowired
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDto> getMovies() throws IOException {
        return movieService.findAllMovie();
    }

    @GetMapping(value = "/filter")
    public List<MovieDto> getMoviesByDate() throws IOException {
        return getMovies();
    }

}