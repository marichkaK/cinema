package com.websystique.springboot.api.repository;

import com.websystique.springboot.api.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findAllByMovieId(Long id);

    void deleteByIdIn(Set<Long> ids);

}
