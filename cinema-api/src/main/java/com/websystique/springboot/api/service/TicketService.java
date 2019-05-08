package com.websystique.springboot.api.service;

import com.websystique.springboot.api.dto.MovieDto;
import com.websystique.springboot.api.model.projection.MovieTotalProjection;
import com.websystique.springboot.api.repository.TicketRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TicketService {


    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

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
}
