package com.example.finaltest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerId")
    private int playerid;
    @Column(name = "NationalId")
    private int nationalid;
    @Column(name = "PlayerName")
    private String playername;
    @Column(name = "HighScore")
    private int highscore;
    @Column(name = "Level")
    private int level;
    @ManyToOne
    @JoinColumn(name = "NationalId", referencedColumnName = "NationalId", insertable = false, updatable = false)
    private National national;

    public National getNational() {
        return national;
    }

    public void setNational(National national) {
        this.national = national;
    }

    public int getPlayerid() {
        return this.playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public int getNationalid() {
        return this.nationalid;
    }

    public void setNationalid(int nationalid) {
        this.nationalid = nationalid;
    }

    public String getPlayername() {
        return this.playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public int getHighscore() {
        return this.highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Player() {
    };

    public Player(int playerid, int nationalid, String playername, int highscore, int level) {
        this.playerid = playerid;
        this.nationalid = nationalid;
        this.playername = playername;
        this.highscore = highscore;
        this.level = level;
    }
}
