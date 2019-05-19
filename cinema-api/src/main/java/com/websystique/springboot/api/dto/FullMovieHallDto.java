package com.websystique.springboot.api.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullMovieHallDto {

    private String name;
    private List<MovieHallPlaceDto> movieHallPlaces;
}
