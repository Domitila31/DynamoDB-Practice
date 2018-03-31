package com.paulina.dynamopractice.service;

import com.paulina.dynamopractice.model.MovieRating;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Optional<MovieRating> getRating(String id);

    MovieRating save(MovieRating movieRating);

    Optional<MovieRating> updateRating(String id, MovieRating movieRating);

    void delete(String id);

    List<MovieRating> findByReviewer(String name);
}
