package com.websystique.springboot.api.controller;

import com.websystique.springboot.api.dto.MovieDto;
import com.websystique.springboot.api.dto.MovieModelDto;
import com.websystique.springboot.api.model.Movie;
import com.websystique.springboot.api.service.MovieService;
import com.websystique.springboot.api.service.TicketService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    private final MovieService movieService;
    private final TicketService ticketService;

    @Autowired
    public MovieRestController(MovieService movieService, TicketService ticketService) {
        this.movieService = movieService;
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<MovieDto> getMovies() {
        List<Movie> movies = movieService.findAllMovies();
        return movies.stream()
            .map(Movie::toDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MovieModelDto getMovie(@PathVariable Long id) {
        return movieService.getMovie(id).toMovieDto();
    }

    @PostMapping
    public MovieModelDto createMovie(@RequestBody MovieModelDto movieDto) {
        Movie movie = movieService.createMovie(movieDto);

        return movie.toMovieDto();
    }

    @GetMapping("/filter")
    public List<MovieDto> getMoviesBy(@RequestParam String age, @RequestParam String topNumberOfMovies) {
        return ticketService.getTheMostSalableMoviesForAge(Integer.parseInt(age), Integer.parseInt(topNumberOfMovies));
    }

}