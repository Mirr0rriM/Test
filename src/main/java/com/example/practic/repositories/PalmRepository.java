package com.example.practic.repositories;

import com.example.practic.models.Palm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalmRepository extends JpaRepository<Palm, Long> {
    Palm findPalmById(Long id);
}
