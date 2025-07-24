package com.example.demo.repository;

import com.example.demo.model.National;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalRepository extends JpaRepository<National, Integer> {
}
