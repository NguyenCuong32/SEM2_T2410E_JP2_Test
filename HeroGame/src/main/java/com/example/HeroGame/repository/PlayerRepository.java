package com.example.HeroGame.repository;

import com.example.HeroGame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByPlayerNameContainingIgnoreCase(String name);
    List<Player> findTop10ByOrderByHighScoreDesc();
}