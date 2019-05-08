package com.websystique.springboot.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
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

    @OneToMany(mappedBy = "movieHallPlace")
    private List<MovieSessionPlaceData> movieSessionPlaceData;
}
