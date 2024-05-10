package com.example.Thetossofcoin.dao;

import com.example.Thetossofcoin.models.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
//
//    @Query("select * from levels where id = :levelId")
//    Optional<Level> findLevelById(Long levelId);
}
