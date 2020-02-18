package com.websystique.springboot.ticket.service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Ticket implements Persistable<String> {

    @Id
    private String id;

    @Field
    private Integer ticketId;

    @Field
    private User user;

    @Field
    private MovieSessionPlaceData movieSessionPlaceData;

    @Override
    public boolean isNew() {
        return id == null;
    }
}
