package com.example.Thetossofcoin.services;

import com.example.Thetossofcoin.models.CreateCompetitionCategories;
import com.example.Thetossofcoin.models.dtos.CompetitionCategoryDto;
import com.example.Thetossofcoin.models.dtos.CompetitionDto;
import org.springframework.http.ResponseEntity;

public interface CompetitionService {
    CompetitionDto saveCompetition(CompetitionDto competitionDto);

    CompetitionDto findById(Long competitionId);

    ResponseEntity<?> createCompetitionCategory(CreateCompetitionCategories competitionCategories);
}
