package com.websystique.springboot.api.repository;

import com.websystique.springboot.api.model.MovieHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieHallRepository extends JpaRepository<MovieHall, Long> {

}
