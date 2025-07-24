package com.example.finaltest.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.finaltest.entity.National;
import com.example.finaltest.repository.INationalRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class NationalService {
    private final INationalRepository rep;
    @PersistenceContext
    private EntityManager em;

    public NationalService(INationalRepository rep) {
        this.rep = rep;
    }

    public List<National> findAll() {
        return rep.findAll();
    }

    public National getbyID(int id) {
        return rep.findById(id).orElse(null);
    }

    public National save(National s) {
        return rep.save(s);
    }

    public void deleteById(int id) {
        rep.deleteById(id);
    }

}
