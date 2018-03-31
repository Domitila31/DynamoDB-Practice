package com.paulina.dynamopractice.service;

import com.paulina.dynamopractice.model.Movie;
import com.paulina.dynamopractice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Optional<Movie> getMovie(Integer id) {
        return movieRepository.findById(id);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> updateMovie(Integer id, Movie movie) {
        Optional<Movie> movieFound = movieRepository.findById(id);
        if(movieFound.isPresent())
        {
            movie.setId(id);
            Movie updatedRating = movieRepository.save(movie);
            return Optional.of(updatedRating);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {
        movieRepository.deleteById(id);
    }
}
