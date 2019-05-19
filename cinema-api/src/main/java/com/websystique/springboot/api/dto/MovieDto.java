package com.websystique.springboot.api.dto;

import com.websystique.springboot.api.model.projection.MovieTotalProjection;
import com.websystique.springboot.api.util.DateConverter;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;

    private String name;

    private Date startDate;

    private Integer numOfTickets;

    public MovieDto(Long id, String name, Date startDate) {
        this.id = id;
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
