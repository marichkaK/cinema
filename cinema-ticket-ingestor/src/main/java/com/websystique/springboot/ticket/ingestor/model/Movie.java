package com.websystique.springboot.ticket.ingestor.model;

import com.websystique.springboot.messaging.common.MovieKafkaDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
    private Long movieId;
    private String name;
    private Integer duration;
    private Integer minAge;
    private String country;

    public static Movie toModel(MovieKafkaDto movieKafkaDto){
        return Movie.builder()
                .name(movieKafkaDto.getName())
                .duration(movieKafkaDto.getDuration())
                .minAge(movieKafkaDto.getMinAge())
                .country(movieKafkaDto.getCountry())
                .build();
    }
}
