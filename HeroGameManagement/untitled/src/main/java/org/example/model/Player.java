package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Player")
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerId")
    private Integer playerId;

    @Column(name = "PlayerName", nullable = false)
    private String playerName;

    @Column(name = "HighScore")
    private Integer highScore;

    @Column(name = "Level")
    private Integer level;

    @ManyToOne // Mối quan hệ nhiều-một với National
    @JoinColumn(name = "NationalId", nullable = false) // <--- Đảm bảo tên cột khóa ngoại là "NationalId"
    private National national;

    // Constructors
    public Player() {
    }

    public Player(String playerName, Integer highScore, Integer level, National national) {
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
        this.national = national;
    }
}