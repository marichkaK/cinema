package com.websystique.springboot.ticket.service.repository;

import com.websystique.springboot.ticket.service.projection.NumberOfTicketsPerUserProjection;

import java.util.List;

public interface TicketRepositoryCustom {

    List<NumberOfTicketsPerUserProjection> getNumberOfTicketsPerUser(Integer limit);
}
