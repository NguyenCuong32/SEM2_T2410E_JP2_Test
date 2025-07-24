package org.example.repository;

import org.example.model.National;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Đánh dấu đây là một Spring Data Repository
public interface NationalRepository extends JpaRepository<National, Integer> {
    // JpaRepository cung cấp sẵn các phương thức CRUD cơ bản: save, findById, findAll, deleteById, v.v.
}
