package com.websystique.springboot.repositories;

import com.websystique.springboot.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByName(String name);

}
