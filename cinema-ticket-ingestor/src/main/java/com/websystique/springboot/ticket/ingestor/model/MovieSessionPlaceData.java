package com.websystique.springboot.ticket.ingestor.model;

import com.websystique.springboot.messaging.common.MovieSessionPlaceDataKafkaDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document
public class MovieSessionPlaceData{
    @Id
    private String id;

    @Field
    private Session session;

    @Field
    private Integer price;

    public static MovieSessionPlaceData toMovieData(MovieSessionPlaceDataKafkaDto movieDto) {
        return new MovieSessionPlaceData( null,
                Session.toModel(movieDto.getSessionKafkaDto()),
                movieDto.getPrice());
    }
}
