package com.websystique.springboot.api.messaging.service;

import com.websystique.springboot.api.messaging.stream.TicketStream;
import com.websystique.springboot.api.model.Ticket;
import com.websystique.springboot.messaging.common.TicketDto;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class TicketStreamService {

    private final TicketStream ticketStream;

    public TicketStreamService(TicketStream ticketStream) {
        this.ticketStream = ticketStream;
    }

    public boolean sendTicket(Ticket ticket) {
        TicketDto dto = TicketDto.builder()
                .ticketId(ticket.getId())
                .user(ticket.getUser().toKafkaDto())
                .movieSessionPlaceDataKafkaDto(ticket.getMovieSessionPlaceData().toKafkaDto())
                .build();

        MessageChannel messageChannel = ticketStream.writeTickets();

        return messageChannel.send(MessageBuilder
                .withPayload(dto)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
