package com.websystique.springboot.model;

import com.websystique.springboot.dto.MovieDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.convert.threetenbp.ThreeTenBackPortJpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static com.websystique.springboot.util.DateConverter.convertToDateViaSqlTimestamp;

@Data
@EqualsAndHashCode
@Entity(name = "Movie")
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
    @Column(name = "format", length = 2)
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
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime startDate;

    @Column(name = "endDate")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime endDate;

    @Column(name = "logoPath")
    private String logoPath;

    @OneToMany(mappedBy = "movie")
    private List<Session> sessions;

    @ManyToMany
    private List<Genre> genres;

    public MovieDto toDto(){
        return new MovieDto(name, convertToDateViaSqlTimestamp(startDate));
    }
}
