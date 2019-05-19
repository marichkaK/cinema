package com.websystique.springboot.api.service;

import com.websystique.springboot.api.model.MovieSessionPlaceData;
import com.websystique.springboot.api.repository.MovieSessionPlaceDataRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieSessionPlaceDataService {

    private final MovieSessionPlaceDataRepository movieSessionPlaceDataRepository;

    @Autowired
    public MovieSessionPlaceDataService(MovieSessionPlaceDataRepository movieSessionPlaceDataRepository) {
        this.movieSessionPlaceDataRepository = movieSessionPlaceDataRepository;
    }

    public List<MovieSessionPlaceData> addMovieSessionPlaceData(List<MovieSessionPlaceData> movieSessionPlaceData) {
        return movieSessionPlaceDataRepository.saveAll(movieSessionPlaceData);
    }

    public MovieSessionPlaceData getMovieSessionPlaceData(Long id) {
        return movieSessionPlaceDataRepository.getOne(id);
    }
}
