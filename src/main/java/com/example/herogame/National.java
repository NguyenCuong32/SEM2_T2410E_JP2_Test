package com.example.herogame;

public class National {
    private int nationalId;
    private String nationalName;

    // Constructor
    public National(int nationalId, String nationalName) {
        this.nationalId = nationalId;
        this.nationalName = nationalName;
    }

    // Getters & Setters
    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | National: %s", nationalId, nationalName);
    }
}

