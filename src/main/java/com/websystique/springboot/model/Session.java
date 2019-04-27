package com.websystique.springboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "movie_hall_id",  nullable = false)
    private MovieHall movieHall;

    @ManyToOne
    @JoinColumn(name = "movie_id",  nullable = false)
    private Movie movie;

    @Column(name = "session_time",  nullable = false)
    private LocalDateTime sessionTime;

    @OneToMany(mappedBy = "session")
    private List<MovieSessionPlaceData> movieSessionPlaceData;
}
