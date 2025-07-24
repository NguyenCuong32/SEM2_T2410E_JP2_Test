package Herogame.demo.Resposirity;

import Herogame.demo.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {


    List<Player> findByPlayerNameContainingIgnoreCase(String name);


    List<Player> findTop10ByOrderByHighScoreDesc();
}
