package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "national")
public class National {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nationalId;

    @Column(name = "national_name")
    private String nationalName;

    public Integer getNationalId() {
        return nationalId;
    }

    public void setNationalId(Integer nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
}
