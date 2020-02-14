package com.websystique.springboot.api.controller;

import com.websystique.springboot.api.model.Ticket;
import com.websystique.springboot.api.model.User;
import com.websystique.springboot.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TicketRestController {

    private final TicketService ticketService;

    @Autowired
    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/places/{movieSessionPlaceDataId}/tickets")
    public ResponseEntity<?> createTicket(
        @PathVariable Long movieSessionPlaceDataId,
        @RequestAttribute(User.CURRENT_USER) User user) {

        Ticket ticket = ticketService.buyTicket(movieSessionPlaceDataId, user);
        if(ticket==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket.toDto());
    }

}