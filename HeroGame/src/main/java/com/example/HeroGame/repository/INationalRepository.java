package com.example.HeroGame.repository;

import com.example.HeroGame.entity.National;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationalRepository extends JpaRepository<National, Integer> {
    // JpaRepository provides all basic CRUD methods.
}