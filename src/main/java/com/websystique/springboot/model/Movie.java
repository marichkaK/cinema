package com.websystique.springboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Enumerated(EnumType.STRING)
    @Column(name = "format")
    private Format format;

    @Column(name = "minAge", nullable = false)
    private Integer minAge;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name = "logoPath")
    private String logoPath;

    @OneToMany(mappedBy = "movie")
    private List<Session> sessions;

//    @OneToMany(mappedBy = "movie")
//    private List<MovieGenre> movieGenres;

    @ManyToMany
    private List<Genre> genres;
}
