package com.paulina.dynamopractice.service;

import com.paulina.dynamopractice.model.Movie;

import java.util.Optional;

public interface MovieService {
    Optional<Movie> getMovie(Integer id);

    Movie save(Movie movie);

    Optional<Movie> updateMovie(Integer id, Movie movie);

    void delete(Integer id);
}
