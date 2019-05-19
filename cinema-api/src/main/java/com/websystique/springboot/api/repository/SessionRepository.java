package com.websystique.springboot.api.repository;

import com.websystique.springboot.api.model.Session;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findAllByMovieId(Long id);
}
