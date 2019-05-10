package com.websystique.springboot.api.model;

import static com.websystique.springboot.api.util.DateConverter.convertToDateViaSqlTimestamp;

import com.websystique.springboot.api.dto.MovieDto;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

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

    public MovieDto toDto() {
        return new MovieDto(name, convertToDateViaSqlTimestamp(startDate));
    }
}