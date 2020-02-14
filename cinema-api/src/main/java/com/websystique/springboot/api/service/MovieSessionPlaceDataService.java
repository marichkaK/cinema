package com.websystique.springboot.api.service;

import com.websystique.springboot.api.model.MovieSessionPlaceData;
import com.websystique.springboot.api.model.Status;
import com.websystique.springboot.api.repository.MovieSessionPlaceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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

    public void updateMovieSessionPlaceDataStatus(Long id) {
        MovieSessionPlaceData movieSessionPlaceData = movieSessionPlaceDataRepository.getOne(id);
        movieSessionPlaceData.setStatus(Status.BOOKED);
        movieSessionPlaceDataRepository.save(movieSessionPlaceData);
    }

    public void deleteMovieSessionPlaceDatasBy(Set<Long> sessionId) {
        movieSessionPlaceDataRepository.deleteAllBySessionIdIn(sessionId);
    }

}
