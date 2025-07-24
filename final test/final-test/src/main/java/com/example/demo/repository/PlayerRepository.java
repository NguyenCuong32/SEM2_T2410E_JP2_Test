package com.example.demo.repository;

import com.example.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByPlayerNameContainingIgnoreCase(String name);
    List<Player> findTop10ByOrderByHighScoreDesc();
}
