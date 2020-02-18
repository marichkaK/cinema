package com.websystique.springboot.ticket.service.repository;

import com.websystique.springboot.ticket.service.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String>, TicketRepositoryCustom {

}
