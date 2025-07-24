package com.example.demo.dto;

public class PlayerTableDTO {
    private Integer playerId;
    private String playerName;
    private Integer highScore;
    private Integer level;
    private String national;

    public PlayerTableDTO(Integer playerId, String playerName, Integer highScore, Integer level, String national) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
        this.national = national;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public Integer getLevel() {
        return level;
    }

    public String getNational() {
        return national;
    }
}
