package com.websystique.springboot.api.dto;

import com.websystique.springboot.api.model.projection.MovieTotalProjection;
import com.websystique.springboot.api.util.DateConverter;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

@Data
public class MovieDto {

    private String name;

    private Date startDate;

    private Integer numOfTickets;

    public MovieDto(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public MovieDto(MovieTotalProjection movieTotalProjection) {
        this.name = movieTotalProjection.getMovie().getName();
        LocalDateTime localDateTime = movieTotalProjection.getMovie().getStartDate();
        this.startDate = DateConverter.convertToDateViaSqlTimestamp(localDateTime);
        this.numOfTickets = movieTotalProjection.getTotalTickets().intValue();
    }
}
