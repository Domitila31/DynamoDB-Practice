package com.paulina.dynamopractice.service;

import com.paulina.dynamopractice.model.MovieRating;
import com.paulina.dynamopractice.dynamoRepository.MovieRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieRatingsServiceImpl implements MovieRatingsService {

    private final MovieRatingsRepository movieRatingsRepository;

    @Autowired
    public MovieRatingsServiceImpl(MovieRatingsRepository movieRatingsRepository){
        this.movieRatingsRepository = movieRatingsRepository;
    }

    @Override
    public Optional<MovieRating> getRating(String id){
        return movieRatingsRepository.findById(id);
    }

    @Override
    public MovieRating save(MovieRating movieRating) {
        return movieRatingsRepository.save(movieRating);
    }

    @Override
    public Optional<MovieRating> updateRating(String id, MovieRating movieRating) {
        Optional<MovieRating> ratingFound = movieRatingsRepository.findById(id);
        if(ratingFound.isPresent())
        {
            movieRating.setId(id);
            MovieRating updatedRating = movieRatingsRepository.save(movieRating);
            return Optional.of(updatedRating);
        }
        return Optional.empty();
    }

    @Override
    public void delete(String id){
        movieRatingsRepository.deleteById(id);
    }

    @Override
    public List<MovieRating> findByReviewer(String name) {
        return movieRatingsRepository.findByReviewer(name);
    }
}
