package com.example.finaltest.service;

public class PlayerDTO {
    private int playerId;
    private String playerName;
    private int highScore;
    private int level;
    private String nationalName;

    public int getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHighScore() {
        return this.highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNationalName() {
        return this.nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }

    // Constructor
    public PlayerDTO(int playerId, String playerName, int highScore, int level, String nationalName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
        this.nationalName = nationalName;
    }

    
}