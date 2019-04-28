package com.websystique.springboot.controller;

import com.websystique.springboot.dto.MovieDto;
import com.websystique.springboot.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.websystique.springboot.util.DateConverter.convertToDateViaSqlTimestamp;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

	public static final Logger logger = LoggerFactory.getLogger(MovieRestController.class);

	@Autowired
	private MovieService movieService; //Service which will do all data retrieval/manipulation work

    @GetMapping
	public List<MovieDto> getMovies() {
		List<MovieDto> list = new ArrayList<>();
		list.add(new MovieDto("Fight club", convertToDateViaSqlTimestamp(LocalDateTime.of(2019,12,2,15,0))));
		list.add(new MovieDto("Dirty 8", convertToDateViaSqlTimestamp(LocalDateTime.of(2019,11,2,15,0))));
		return list;
	}

}