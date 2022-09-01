package com.example.practic.repositories;

import com.example.practic.models.Oak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OakRepository extends JpaRepository<Oak, Long> {
    Oak findOakById(Long id);
}
