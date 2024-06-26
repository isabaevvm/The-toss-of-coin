package com.example.Thetossofcoin.dao;

import com.example.Thetossofcoin.models.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
    Optional<Gender> findById(Long genderId);
}
