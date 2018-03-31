package com.paulina.dynamopractice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="Movies", schema="public")
public class Movie {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;

    private String createdBy;

    private Date createdDate;

    private Date modifiedDate;

    private Integer releaseYear;
}
