package com.websystique.springboot.api.service;

import com.websystique.springboot.api.dto.MovieDto;
import com.websystique.springboot.api.messaging.service.TicketStreamService;
import com.websystique.springboot.api.model.MovieSessionPlaceData;
import com.websystique.springboot.api.model.Ticket;
import com.websystique.springboot.api.model.User;
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
    private final MovieSessionPlaceDataService movieSessionPlaceDataService;
    private final TicketStreamService ticketStreamService;

    @Autowired
    public TicketService(
        TicketRepository ticketRepository,
        MovieSessionPlaceDataService movieSessionPlaceDataService,
        TicketStreamService ticketStreamService) {

        this.ticketRepository = ticketRepository;
        this.movieSessionPlaceDataService = movieSessionPlaceDataService;
        this.ticketStreamService = ticketStreamService;
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

    @Transactional
    public Ticket buyTicket(Long movieSessionPlaceDataId, User user) {
        MovieSessionPlaceData movieSessionPlaceData
            = movieSessionPlaceDataService.getMovieSessionPlaceData(movieSessionPlaceDataId);

        Ticket ticket = ticketRepository.save(new Ticket(user, movieSessionPlaceData));

        ticketStreamService.sendTicket(ticket);

        return ticket;
    }
}
