package com.example.HeroGame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nationalId;

    private String nationalName;
}