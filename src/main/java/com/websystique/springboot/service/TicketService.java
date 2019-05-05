package com.websystique.springboot.service;

import com.websystique.springboot.dto.MovieDto;
import com.websystique.springboot.model.Movie;
import com.websystique.springboot.model.projection.MovieTotalProjection;
import com.websystique.springboot.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ticketService")
@Transactional
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<MovieDto> getTheMostSalableMoviesForAge(Integer age, Integer topNumberOfMovies) {
        List<MovieTotalProjection> movieTotalProjections
                = ticketRepository.findTheMostSalableMovieByAge(age, new PageRequest(0, topNumberOfMovies));
        List<MovieDto> movieDtos = new ArrayList<>();
        for (int i = 0; i < movieTotalProjections.size(); i++) {
            MovieDto movieDto = new MovieDto(movieTotalProjections.get(i));
            movieDtos.add(movieDto);
        }
        return movieDtos;
    }

    public Map<Movie, Long> getTheMostSalableMovieByGenre(String genre) {
        return new HashMap<>();
    }

}
