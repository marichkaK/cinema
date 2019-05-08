package com.websystique.springboot.controller;

import com.websystique.springboot.dto.MovieDto;
import com.websystique.springboot.model.Movie;
import com.websystique.springboot.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

	public static final Logger logger = LoggerFactory.getLogger(MovieRestController.class);

	@Autowired
	private MovieService movieService; //Service which will do all data retrieval/manipulation work

	@GetMapping
	public List<MovieDto> getMovies() {
		List<Movie> movies = movieService.findAllMovie();
		return movies.stream()
				.map(Movie::toDto)
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/filter")
	public List<MovieDto> getMoviesByDate() {
		List<Movie> movies = movieService.findAllMovie();
		return movies.stream()
				.map(Movie::toDto)
				.collect(Collectors.toList());
	}

}