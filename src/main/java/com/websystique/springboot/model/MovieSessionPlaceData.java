package com.websystique.springboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity(name = "MovieSessionPlaceData")
@Table(name = "movie_session_place_data")
public class MovieSessionPlaceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "movie_hall_place_id")
    private MovieHallPlace movieHallPlace;

    @Column(name = "price")
    private Integer price;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "movieSessionPlaceData")
    private List<Ticket> tickets;
}
