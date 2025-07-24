package Herogame.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    @ManyToOne
    @JoinColumn(name = "NationalId")
    private National national;

    @Column(name = "PlayerName")
    private String playerName;

    @Column(name = "HighScore")
    private int highScore;

    @Column(name = "Level")
    private int level;


    public Player() {}

    public Player(National national, String playerName, int highScore, int level) {
        this.national = national;
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
    }


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public National getNational() {
        return national;
    }

    public void setNational(National national) {
        this.national = national;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
