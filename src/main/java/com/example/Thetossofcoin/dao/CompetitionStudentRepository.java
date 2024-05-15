package com.example.Thetossofcoin.dao;

import com.example.Thetossofcoin.models.entities.CompetitionStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionStudentRepository extends JpaRepository<CompetitionStudent, Long> {
}
