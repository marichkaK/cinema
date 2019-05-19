package com.websystique.springboot.api.model;

import com.websystique.springboot.api.dto.FullSessionDto;
import com.websystique.springboot.api.dto.MovieSessionPlaceDataDto;
import com.websystique.springboot.api.dto.SessionDto;
import com.websystique.springboot.api.util.DateConverter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Session")
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_hall_id")
    private MovieHall movieHall;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "session_time", nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime sessionTime;

    @OneToMany(mappedBy = "session")
    private List<MovieSessionPlaceData> movieSessionPlaceData;

    public SessionDto toDto() {
        return SessionDto.builder()
            .id(id)
            .movie(movie.toDto())
            .sessionTime(DateConverter.convertToDateViaSqlTimestamp(sessionTime))
            .build();
    }

    public FullSessionDto toFullSessionDto() {
        return FullSessionDto.builder()
            .id(id)
            .movie(movie.toDto())
            .movieHall(movieHall.toDto())
            .sessionTime(DateConverter.convertToDateViaSqlTimestamp(sessionTime))
            .placeDataList(getMovieSessionPlaceDataList())
            .build();
    }

    private List<MovieSessionPlaceDataDto> getMovieSessionPlaceDataList() {
        return movieSessionPlaceData.stream()
            .map(MovieSessionPlaceData::toDto)
            .collect(Collectors.toList());
    }
}
