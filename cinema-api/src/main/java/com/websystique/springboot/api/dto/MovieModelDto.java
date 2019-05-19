package com.websystique.springboot.api.dto;

import com.websystique.springboot.api.model.Format;
import com.websystique.springboot.api.model.Movie;
import com.websystique.springboot.api.util.DateConverter;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieModelDto {

    private String name;
    private Integer duration;
    private String format;
    private Integer minAge;
    private Integer year;
    private String country;
    private String description;
    private Date startDate;
    private Date endDate;
    private String logoPath;
    private List<String> genres;

    public Movie toMovie() {
        return Movie.builder()
            .name(name)
            .duration(duration)
            .format(Format.valueOf(format))
            .minAge(minAge)
            .year(year)
            .country(country)
            .description(description)
            .startDate(DateConverter.toLocalDateTime(startDate))
            .endDate(DateConverter.toLocalDateTime(endDate))
            .logoPath(logoPath)
            .build();
    }
}
