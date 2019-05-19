package com.websystique.springboot.api.controller;

import com.websystique.springboot.api.dto.FullMovieHallDto;
import com.websystique.springboot.api.dto.MovieHallDto;
import com.websystique.springboot.api.model.MovieHall;
import com.websystique.springboot.api.service.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie_halls")
public class MovieHallRestController {

    private final MovieHallService movieHallService;

    @Autowired
    public MovieHallRestController(MovieHallService movieHallService) {
        this.movieHallService = movieHallService;
    }

    @PostMapping
    public FullMovieHallDto createMovieHall(@RequestBody MovieHallDto movieHallDto) {
        MovieHall movieHall = movieHallService.createMovieHall(movieHallDto);

        return movieHall.toFullDto();
    }
}