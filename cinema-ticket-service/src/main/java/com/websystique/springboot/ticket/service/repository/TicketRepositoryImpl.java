package com.websystique.springboot.ticket.service.repository;

import com.websystique.springboot.ticket.service.projection.NumberOfTicketsPerUserProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Component
public class TicketRepositoryImpl implements TicketRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public TicketRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<NumberOfTicketsPerUserProjection> getNumberOfTicketsPerUser(Integer limit) {
        GroupOperation groupTickets = group("user").first("user").as("user").count().as("numberOfTickets");
        SortOperation sortByNumDesc = sort(new Sort(Sort.Direction.DESC, "numberOfTickets"));
        LimitOperation limitOperation = limit(limit);

        Aggregation aggregation = newAggregation(groupTickets, limitOperation, sortByNumDesc);
        AggregationResults<NumberOfTicketsPerUserProjection> result = mongoTemplate.aggregate(
                aggregation, "ticket", NumberOfTicketsPerUserProjection.class);
        return result.getMappedResults();
    }
}
