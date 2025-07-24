package Herogame.demo.Service;

import Herogame.demo.Entity.Player;
import Herogame.demo.Resposirity.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;


    public Player insertPlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(int playerId) {
        playerRepository.deleteById(playerId);
    }


    public List<Player> displayAllPlayers() {
        return playerRepository.findAll();
    }


    public List<Player> displayAllByPlayerName(String name) {
        return playerRepository.findByPlayerNameContainingIgnoreCase(name);
    }


    public List<Player> displayTop10Players() {
        return playerRepository.findTop10ByOrderByHighScoreDesc();
    }
}
