package com.websystique.springboot.ticket.service.service;

import com.websystique.springboot.ticket.service.dto.NumberOfTicketsPerUserDto;
import com.websystique.springboot.ticket.service.projection.NumberOfTicketsPerUserProjection;
import com.websystique.springboot.ticket.service.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<NumberOfTicketsPerUserDto> getNumberOfTicketsPerUser(Integer limitUsersQuantity) {
        return ticketRepository.getNumberOfTicketsPerUser(limitUsersQuantity)
                .stream()
                .map(NumberOfTicketsPerUserProjection::toDto)
                .collect(Collectors.toList());
    }
}
