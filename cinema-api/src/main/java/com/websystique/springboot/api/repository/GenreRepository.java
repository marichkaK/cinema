package com.websystique.springboot.api.repository;

import com.websystique.springboot.api.model.Genre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    List<Genre> findByNameIn(List<String> names);

}
