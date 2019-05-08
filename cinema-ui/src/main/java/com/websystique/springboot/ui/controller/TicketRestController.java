package com.websystique.springboot.ui.controller;

import com.websystique.springboot.ui.dto.MovieDto;
import com.websystique.springboot.ui.service.MovieService;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class TicketRestController {

    private final MovieService movieService;

    @Autowired
    public TicketRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDto> getMoviesBy(@RequestParam String age, @RequestParam String topNumberOfMovies)
        throws IOException, URISyntaxException {

        return movieService.getTheMostSalableMoviesForAge(age, topNumberOfMovies);
    }
}