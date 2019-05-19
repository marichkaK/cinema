package com.websystique.springboot.api.model;

import com.websystique.springboot.api.dto.TicketDto;
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
@Entity(name = "Ticket")
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_session_place_id")
    private MovieSessionPlaceData movieSessionPlaceData;

    public Ticket(User user, MovieSessionPlaceData movieSessionPlaceData) {
        this.user = user;
        this.movieSessionPlaceData = movieSessionPlaceData;
    }

    public TicketDto toDto() {
        return TicketDto.builder()
            .id(id)
            .userId(user.getId())
            .movieSessionPlaceDataId(movieSessionPlaceData.getId())
            .build();
    }
}
