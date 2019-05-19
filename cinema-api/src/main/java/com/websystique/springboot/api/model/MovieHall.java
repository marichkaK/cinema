package com.websystique.springboot.api.model;

import com.websystique.springboot.api.dto.FullMovieHallDto;
import com.websystique.springboot.api.dto.MovieHallDto;
import com.websystique.springboot.api.dto.MovieHallPlaceDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "MovieHall")
@Table(name = "movie_hall")
public class MovieHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "movieHall")
    private List<MovieHallPlace> movieHallPlaces;

    public MovieHall(String name) {
        this.name = name;
    }

    public MovieHallDto toDto() {
        return new MovieHallDto(name);
    }

    public FullMovieHallDto toFullDto() {
        List<MovieHallPlaceDto> hallPlaceDtos = movieHallPlaces.stream()
            .map(MovieHallPlace::toDto)
            .collect(Collectors.toList());

        return new FullMovieHallDto(name, hallPlaceDtos);
    }
}
