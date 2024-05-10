package com.example.Thetossofcoin.dao;

import com.example.Thetossofcoin.models.entities.Generation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenerationRepository extends JpaRepository<Generation, Long> {
    Optional<Generation> findByValue(String value);
}
