package com.websystique.springboot.api.service;

import com.websystique.springboot.api.dto.GenreDto;
import com.websystique.springboot.api.model.Genre;
import com.websystique.springboot.api.repository.GenreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findByNames(List<String> names) {
        return genreRepository.findByNameIn(names);
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Genre createGenre(GenreDto genreDto) {
        return genreRepository.save(new Genre(genreDto.getName()));
    }
}
