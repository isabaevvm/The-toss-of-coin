package com.example.Thetossofcoin.dao;

import com.example.Thetossofcoin.models.entities.CompetitionCategory;
import com.example.Thetossofcoin.models.entities.CompetitionLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetitionLimitRepository extends JpaRepository<CompetitionLimit, Long> {

    @Query(value = "select c from CompetitionLimit c where c.competitionCategory = :competitionCategory and :weight > c.weightFrom and :weight < c.weightTo")
    Optional<CompetitionLimit> findByCompetitionCategoryAndWeight(CompetitionCategory competitionCategory, Integer weight);

}
