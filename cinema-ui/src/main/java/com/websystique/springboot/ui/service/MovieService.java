package com.websystique.springboot.ui.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.websystique.springboot.ui.dto.MovieDto;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Value("${app.urls.api}")
    private String appBaseApi;

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public MovieService(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    public List<MovieDto> findAllMovie()
        throws IOException {

        HttpResponse response = httpClient.execute(new HttpGet(appBaseApi + "/api/movies"));

        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            return null;
        }

        return getMovieDtos(response);
    }

    public List<MovieDto> getTheMostSalableMoviesForAge(String age, String topNumberOfMovies)
        throws IOException, URISyntaxException {

        URIBuilder builder = new URIBuilder(appBaseApi + "/api/movies/filter");
        builder.setParameter("age", age)
            .setParameter("topNumberOfMovies", topNumberOfMovies);

        HttpResponse response = httpClient.execute(new HttpGet(builder.build()));

        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            return null;
        }

        return getMovieDtos(response);
    }

    private List<MovieDto> getMovieDtos(HttpResponse response) throws IOException {
        return objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<MovieDto>>() {
        });
    }
}
