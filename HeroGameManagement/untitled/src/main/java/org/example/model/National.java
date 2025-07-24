package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "National")
@Data
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NationalId")
    private Integer nationalId;

    @Column(name = "NationalName", nullable = false)
    private String nationalName;

    @OneToMany(mappedBy = "national", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // <--- mappedBy="national"
    private List<Player> players;

    public National() {
    }

    public National(String nationalName) {
        this.nationalName = nationalName;
    }
}