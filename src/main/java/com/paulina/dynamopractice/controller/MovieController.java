package com.paulina.dynamopractice.controller;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.*;
import com.paulina.dynamopractice.model.Movie;
import com.paulina.dynamopractice.repository.MovieRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody Movie movie)
    {
        if(StringUtils.isEmpty(movie.Title))
        {
             return new ResponseEntity<>("Title is mandatory.", HttpStatus.BAD_REQUEST);
        }

        Movie movieCreated = movieRepository.save(movie);
        return new ResponseEntity<>(movieCreated, HttpStatus.CREATED);
    }
}