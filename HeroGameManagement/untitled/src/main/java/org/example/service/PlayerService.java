package org.example.service;

import org.example.model.Player;
import org.example.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // 2. Allow to show all players on the screen as Table1.
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    // 1. Allow add new players into the Playertable.
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    // 1. Remove a player.
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }

    // 3. Allow to find a player by name.
    public List<Player> findPlayersByName(String name) {
        return playerRepository.findByPlayerNameContainingIgnoreCase(name);
    }

    // 4. Allow to show top 10 players where having the most highscore.
    public List<Player> getTop10Players() {
        return playerRepository.findTop10ByOrderByHighScoreDesc();
    }
}
