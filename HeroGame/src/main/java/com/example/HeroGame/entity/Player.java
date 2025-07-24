package com.example.HeroGame.entity;

import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    private String playerName;
    private int highScore;
    private int level;

    @ManyToOne
    @JoinColumn(name = "national_id")
    private National national;

    // Getters & Setters
    public int getPlayerId() { return playerId; }
    public void setPlayerId(int playerId) { this.playerId = playerId; }
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public int getHighScore() { return highScore; }
    public void setHighScore(int highScore) { this.highScore = highScore; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public National getNational() { return national; }
    public void setNational(National national) { this.national = national; }
}
