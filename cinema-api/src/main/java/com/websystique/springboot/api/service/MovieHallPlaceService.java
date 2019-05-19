package com.websystique.springboot.api.service;

import com.websystique.springboot.api.model.MovieHallPlace;
import com.websystique.springboot.api.repository.MovieHallPlaceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieHallPlaceService {

    private final MovieHallPlaceRepository movieHallPlaceRepository;

    @Autowired
    public MovieHallPlaceService(MovieHallPlaceRepository movieHallPlaceRepository) {
        this.movieHallPlaceRepository = movieHallPlaceRepository;
    }

    public List<MovieHallPlace> createMovieHallPlaces(List<MovieHallPlace> movieHallPlaces) {
        return movieHallPlaceRepository.saveAll(movieHallPlaces);
    }
}
