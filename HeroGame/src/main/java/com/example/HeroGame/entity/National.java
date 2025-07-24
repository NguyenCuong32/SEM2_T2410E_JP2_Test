package com.example.HeroGame.entity;

import jakarta.persistence.*;

@Entity
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nationalId;

    private String nationalName;

    // Getters & Setters
    public int getNationalId() { return nationalId; }
    public void setNationalId(int nationalId) { this.nationalId = nationalId; }
    public String getNationalName() { return nationalName; }
    public void setNationalName(String nationalName) { this.nationalName = nationalName; }
}
