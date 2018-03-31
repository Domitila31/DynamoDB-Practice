package com.paulina.dynamopractice.controller;

import com.paulina.dynamopractice.model.MovieRating;
import com.paulina.dynamopractice.service.MovieRatingsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class MovieRatingController {

    @Autowired
    private MovieRatingsService movieRatingsService;

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody MovieRating movieRating)
    {
        if(StringUtils.isEmpty(movieRating.movieTitle))
        {
             return new ResponseEntity<>("Title is mandatory.", HttpStatus.BAD_REQUEST);
        }

        MovieRating movieRatingCreated = movieRatingsService.save(movieRating);
        return new ResponseEntity<>(movieRatingCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id)
    {
        if(StringUtils.isEmpty(id))
        {
            return new ResponseEntity<>("ID is mandatory.", HttpStatus.BAD_REQUEST);
        }

        Optional<MovieRating> movieRatingsCreated = movieRatingsService.getRating(id);
        if(movieRatingsCreated.isPresent())
        {
            return new ResponseEntity<>(movieRatingsCreated, HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody MovieRating rating) {
        if(StringUtils.isNotEmpty(rating.getId()) && !rating.getId().equals(id))
        {
            return new ResponseEntity<>("Incorrect ID.", HttpStatus.BAD_REQUEST);
        }
        Optional<MovieRating> updatedRating = movieRatingsService.updateRating(id, rating);
        if(updatedRating.isPresent()) {
            return new ResponseEntity<>(updatedRating.get(), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        movieRatingsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{name}/reviewer")
    public List<MovieRating> findByReviewer(@PathVariable String name) {
        return movieRatingsService.findByReviewer(name);
    }
}