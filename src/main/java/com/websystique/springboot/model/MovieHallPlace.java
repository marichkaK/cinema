package com.websystique.springboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "movie_hall_place")
public class MovieHallPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "movie_hall_id", nullable = false)
    private Long movieHallId;

    @Column(name = "row", nullable = false)
    private Integer row;

    @Column(name = "seat", nullable = false)
    private Integer seat;

    @OneToMany(mappedBy = "movieHallPlace")
    private List<MovieSessionPlaceData> movieSessionPlaceData;
}
