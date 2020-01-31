package com.websystique.springboot.api.controller;

import com.websystique.springboot.api.dto.TicketDto;
import com.websystique.springboot.api.model.Ticket;
import com.websystique.springboot.api.model.User;
import com.websystique.springboot.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicketRestController {

    private final TicketService ticketService;

    @Autowired
    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/places/{movieSessionPlaceDataId}/tickets")
    public TicketDto createTicket(
        @PathVariable Long movieSessionPlaceDataId,
        @RequestAttribute(User.CURRENT_USER) User user) {

        Ticket ticket = ticketService.buyTicket(movieSessionPlaceDataId, user);

        return ticket.toDto();
    }

}