package com.example.finaltest.entity;

import jakarta.persistence.*;
@Entity
@Table(name="National")
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NationalId")
    private int nationalid;
    @Column(name = "NationalName")
    private String nationalname;

    public int getNationalid() {
        return this.nationalid;
    }

    public void setNationalid(int nationalid) {
        this.nationalid = nationalid;
    }

    public String getNationalname() {
        return this.nationalname;
    }

    public void setNationalname(String nationalname) {
        this.nationalname = nationalname;
    }
    public National(){};
    public National(int nationalid,String nationalname){
        this.nationalid=nationalid;
        this.nationalname=nationalname;
    }
}
