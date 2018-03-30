package com.paulina.dynamopractice.repository;

import com.paulina.dynamopractice.model.Movie;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MovieRepository extends CrudRepository<Movie, String> {

}
