package com.example.HeroGame.repository;

import com.example.HeroGame.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {

    List<Player> findByPlayerNameContainingIgnoreCase(String name);

    List<Player> findTop10ByOrderByHighScoreDesc();
}