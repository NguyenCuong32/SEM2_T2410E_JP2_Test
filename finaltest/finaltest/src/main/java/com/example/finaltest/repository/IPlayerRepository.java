package com.example.finaltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finaltest.entity.Player;

public interface IPlayerRepository extends JpaRepository<Player,Integer> {

}
