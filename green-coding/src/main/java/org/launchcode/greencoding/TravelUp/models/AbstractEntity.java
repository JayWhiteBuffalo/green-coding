package org.launchcode.greencoding.TravelUp.models;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AbstractEntity() {
        // Default constructor
    }

    public AbstractEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}