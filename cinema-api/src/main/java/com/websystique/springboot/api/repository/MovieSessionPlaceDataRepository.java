package com.websystique.springboot.api.repository;

import com.websystique.springboot.api.model.MovieSessionPlaceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MovieSessionPlaceDataRepository extends JpaRepository<MovieSessionPlaceData, Long> {
    void deleteAllBySession_IdIn(Set<Long> ids);
}
