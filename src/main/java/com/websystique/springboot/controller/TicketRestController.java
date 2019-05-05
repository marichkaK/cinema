package com.websystique.springboot.controller;

import com.websystique.springboot.dto.MovieDto;
import com.websystique.springboot.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketRestController {

	@Autowired
	private TicketService ticketService;

	@GetMapping
	public List<MovieDto> getMoviesBy(@RequestParam String age, @RequestParam String topNumberOfMovies) {
		return ticketService.getTheMostSalableMoviesForAge(Integer.parseInt(age), Integer.parseInt(topNumberOfMovies));
	}
}