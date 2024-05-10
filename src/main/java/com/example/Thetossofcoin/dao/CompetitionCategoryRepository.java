package com.example.Thetossofcoin.dao;

import com.example.Thetossofcoin.models.entities.CompetitionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionCategoryRepository extends JpaRepository<CompetitionCategory, Long> {

}
