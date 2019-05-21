package com.websystique.springboot.ticket.ingestor.messaging;

import com.websystique.springboot.messaging.common.TicketDto;
import com.websystique.springboot.ticket.ingestor.service.TicketService;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TicketListener {

    private final TicketService ticketService;

    public TicketListener(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @StreamListener(TicketStream.INPUT)
    public void readTicket(@Payload TicketDto ticketDto) {
        ticketService.save(ticketDto);
    }
}
