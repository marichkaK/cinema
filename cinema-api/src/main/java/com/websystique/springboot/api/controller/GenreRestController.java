package com.websystique.springboot.api.controller;

import com.websystique.springboot.api.dto.GenreDto;
import com.websystique.springboot.api.model.Genre;
import com.websystique.springboot.api.service.GenreService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genres")
public class GenreRestController {

    private final GenreService genreService;

    @Autowired
    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<GenreDto> getGenres() {
        List<Genre> genres = genreService.getGenres();
        return genres.stream()
            .map(Genre::toDto)
            .collect(Collectors.toList());
    }

    @PostMapping
    public GenreDto addGenre(@RequestBody GenreDto genreDto) {
        Genre genre = genreService.createGenre(genreDto);

        return genre.toDto();
    }

}