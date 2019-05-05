package com.websystique.springboot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.convert.threetenbp.ThreeTenBackPortJpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity(name = "Session")
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "movie_hall_id")
    private MovieHall movieHall;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "session_time",  nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime sessionTime;

    @OneToMany(mappedBy = "session")
    private List<MovieSessionPlaceData> movieSessionPlaceData;
}
