package com.example.practic.repositories;

import com.example.practic.models.Sequoia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequoiaRepository extends JpaRepository<Sequoia, Long> {
    Sequoia findSequoiaById(Long id);
}
