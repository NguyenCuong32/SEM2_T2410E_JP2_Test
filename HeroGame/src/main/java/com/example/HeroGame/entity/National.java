package com.example.HeroGame.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "National")
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nationalId;

    @Column(nullable = false, unique = true)
    private String nationalName;


    public National() {
    }

    public National(String nationalName) {
        this.nationalName = nationalName;
    }


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

    // equals, hashCode, and toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        National national = (National) o;
        return Objects.equals(nationalId, national.nationalId) && Objects.equals(nationalName, national.nationalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalId, nationalName);
    }

    @Override
    public String toString() {
        return "National{" +
                "nationalId=" + nationalId +
                ", nationalName='" + nationalName + '\'' +
                '}';
    }
}