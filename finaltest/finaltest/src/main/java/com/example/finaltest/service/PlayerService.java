package com.example.finaltest.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.finaltest.entity.Player;
import com.example.finaltest.repository.IPlayerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class PlayerService {
    private final IPlayerRepository rep;
    @PersistenceContext
    private EntityManager em;

    public PlayerService(IPlayerRepository rep) {
        this.rep = rep;
    }

    public List<Player> findAll() {
        return rep.findAll();
    }

    public Player getbyID(int id) {
        return rep.findById(id).orElse(null);
    }

    public Player save(Player s) {
        return rep.save(s);
    }

    public void deleteById(int id) {
        rep.deleteById(id);
    }

}
