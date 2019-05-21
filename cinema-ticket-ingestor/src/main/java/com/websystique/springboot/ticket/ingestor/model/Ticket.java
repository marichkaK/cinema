package com.websystique.springboot.ticket.ingestor.model;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document
public class Ticket implements Persistable<String> {

    @Id
    private String id;

    @Field
    private Long ticketId;

    @Field
    private User user;

    @CreatedDate
    private Date creationTime;

    @Override
    public boolean isNew() {
        return id == null;
    }

}
