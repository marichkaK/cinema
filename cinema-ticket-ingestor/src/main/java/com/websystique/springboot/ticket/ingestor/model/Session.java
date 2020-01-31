package com.websystique.springboot.ticket.ingestor.model;

import com.websystique.springboot.messaging.common.SessionKafkaDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Session {
    private Movie movie;

    public static Session toModel(SessionKafkaDto sessionDto){
        return Session.builder()
                .movie(Movie.toModel(sessionDto.getMovieKafkaDto()))
                .build();
    }
}
