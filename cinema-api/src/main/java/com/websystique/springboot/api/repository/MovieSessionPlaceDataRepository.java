package com.websystique.springboot.api.repository;

import com.websystique.springboot.api.model.MovieSessionPlaceData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieSessionPlaceDataRepository extends JpaRepository<MovieSessionPlaceData, Long> {

}
