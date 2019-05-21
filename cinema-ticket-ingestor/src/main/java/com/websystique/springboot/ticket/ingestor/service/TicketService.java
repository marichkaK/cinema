package com.websystique.springboot.ticket.ingestor.service;

import com.websystique.springboot.messaging.common.TicketDto;
import com.websystique.springboot.ticket.ingestor.model.Ticket;
import com.websystique.springboot.ticket.ingestor.model.User;
import com.websystique.springboot.ticket.ingestor.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void save(TicketDto ticketDto) {
        Ticket ticket = Ticket.builder()
            .ticketId(ticketDto.getTicketId())
            .user(User.toUser(ticketDto.getUser()))
            .build();

        ticketRepository.save(ticket);
    }
}
