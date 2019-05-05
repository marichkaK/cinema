package com.websystique.springboot.dto;

import com.websystique.springboot.model.projection.MovieTotalProjection;
import com.websystique.springboot.util.DateConverter;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MovieDto {

    private String name;

    private Date startDate;

    private Integer numOfTickets;

    public MovieDto(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public MovieDto(MovieTotalProjection movieTotalProjection){
        this.name = movieTotalProjection.getMovie().getName();
        LocalDateTime localDateTime = movieTotalProjection.getMovie().getStartDate();
        this.startDate = DateConverter.convertToDateViaSqlTimestamp(localDateTime);
        this.numOfTickets = movieTotalProjection.getTotalTickets().intValue();
    }
}
