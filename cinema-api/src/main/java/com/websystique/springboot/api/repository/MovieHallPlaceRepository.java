package com.websystique.springboot.api.repository;

import com.websystique.springboot.api.model.MovieHallPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieHallPlaceRepository extends JpaRepository<MovieHallPlace, Long> {

}
