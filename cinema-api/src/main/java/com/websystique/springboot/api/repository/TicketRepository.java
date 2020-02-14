package com.websystique.springboot.api.repository;

import com.websystique.springboot.api.model.Ticket;
import com.websystique.springboot.api.model.projection.MovieTotalProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT new com.websystique.springboot.api.model.projection.MovieTotalProjection(m, count(t.id)) FROM Ticket t" +
            "    JOIN t.user u" +
            "    JOIN t.movieSessionPlaceData mspd" +
            "    JOIN mspd.session s" +
            "    JOIN s.movie m" +
            "    WHERE u.age = :age" +
            "    GROUP BY m.id" +
            "    ORDER BY count(t.id) DESC")
    List<MovieTotalProjection> findTheMostSalableMovieByAge(
            @Param("age") Integer age,
            Pageable pageable
    );

    List<Ticket> getAllByMovieSessionPlaceDataSessionSessionTimeIsLessThan(LocalDateTime date);

}
