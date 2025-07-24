package Herogame.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "National")
public class National {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nationalId;

    @Column(name = "NationalName")
    private String nationalName;

    // Constructors
    public National() {}

    public National(String nationalName) {
        this.nationalName = nationalName;
    }

    // Getters and Setters
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
}
