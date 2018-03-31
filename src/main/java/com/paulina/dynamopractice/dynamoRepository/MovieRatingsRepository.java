package com.paulina.dynamopractice.dynamoRepository;

import com.paulina.dynamopractice.model.MovieRating;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface MovieRatingsRepository extends CrudRepository<MovieRating, String> {

    List<MovieRating> findByReviewer(String name);
}
