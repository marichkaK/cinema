package com.websystique.springboot.api.model;

import com.websystique.springboot.api.dto.MovieHallPlaceDto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "MovieHallPlace")
@Table(name = "movie_hall_place")
public class MovieHallPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_hall_id")
    private MovieHall movieHall;

    @Column(name = "row_for_seat", nullable = false)
    private Integer rowForSeat;

    @Column(name = "seat", nullable = false)
    private Integer seat;

    public MovieHallPlace(MovieHall movieHall, Integer rowForSeat, Integer seat) {
        this.movieHall = movieHall;
        this.rowForSeat = rowForSeat;
        this.seat = seat;
    }

    public MovieHallPlaceDto toDto() {
        return MovieHallPlaceDto.builder()
            .rowForSeat(rowForSeat)
            .seat(seat)
            .build();
    }
}
