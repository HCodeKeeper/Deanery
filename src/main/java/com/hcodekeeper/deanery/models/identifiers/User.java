package com.hcodekeeper.deanery.models.identifiers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class User {//marked class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
