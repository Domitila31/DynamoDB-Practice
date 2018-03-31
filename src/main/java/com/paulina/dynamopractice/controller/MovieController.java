package com.paulina.dynamopractice.controller;

import com.paulina.dynamopractice.model.Movie;
import com.paulina.dynamopractice.service.MovieService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Movie movie) {
        if (StringUtils.isEmpty(movie.getTitle())) {
            return new ResponseEntity<>("Title is mandatory.", HttpStatus.BAD_REQUEST);
        }

        Movie movieCreated = movieService.save(movie);
        return new ResponseEntity<>(movieCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        if (id <= 0) {
            return new ResponseEntity<>("ID is mandatory.", HttpStatus.BAD_REQUEST);
        }

        Optional<Movie> movieRatingsCreated = movieService.getMovie(id);
        if (movieRatingsCreated.isPresent()) {
            return new ResponseEntity<>(movieRatingsCreated, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @RequestBody Movie movie) {
        if(movie.getId() != null && !movie.getId().equals(id))
        {
            return new ResponseEntity<>("Incorrect ID.", HttpStatus.BAD_REQUEST);
        }
        Optional<Movie> updatedMovie = movieService.updateMovie(id, movie);
        if(updatedMovie.isPresent()) {
            return new ResponseEntity<>(updatedMovie.get(), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
