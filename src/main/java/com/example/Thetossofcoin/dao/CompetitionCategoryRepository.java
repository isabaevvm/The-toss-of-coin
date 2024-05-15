package com.example.Thetossofcoin.dao;

import com.example.Thetossofcoin.models.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetitionCategoryRepository extends JpaRepository<CompetitionCategory, Long> {

    @Query(value = "select c from CompetitionCategory c " +
            "where c.competition = :competition " +
            "and c.level = :level " +
            "and c.gender = :gender " +
            "and c.generation = :generation ")
    Optional<CompetitionCategory> findByCompetitionAndCategories(Competition competition, Level level, Gender gender, Generation generation);

}
