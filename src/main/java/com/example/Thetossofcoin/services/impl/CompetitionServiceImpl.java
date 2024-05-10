package com.example.Thetossofcoin.services.impl;

import com.example.Thetossofcoin.dao.CompetitionCategoryRepository;
import com.example.Thetossofcoin.dao.CompetitionRepository;
import com.example.Thetossofcoin.mappers.*;
import com.example.Thetossofcoin.models.CreateCompetitionCategories;
import com.example.Thetossofcoin.models.dtos.CompetitionDto;
import com.example.Thetossofcoin.models.dtos.GenderDto;
import com.example.Thetossofcoin.models.dtos.GenerationDto;
import com.example.Thetossofcoin.models.dtos.LevelDto;
import com.example.Thetossofcoin.models.entities.*;
import com.example.Thetossofcoin.services.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final CompetitionMapper competitionMapper;
    private final CompetitionCategoryRepository competitionCategoryRepository;
    private final LevelMapper levelMapper;
    private final GenderMapper genderMapper;
    private final GenerationMapper generationMapper;

    @Override
    public CompetitionDto saveCompetition(CompetitionDto competitionDto) {
        Competition savedCompetition = competitionRepository.save(competitionMapper.toEntity(competitionDto));
        return competitionMapper.toDto(savedCompetition);
    }

    @Override
    public CompetitionDto findById(Long competitionId) {
        Optional<Competition> competition = competitionRepository.findById(competitionId);
        if (competition.isEmpty()) throw new NullPointerException(String.format("Соревнование с таким id: %s не найден", competitionId));
        return competitionMapper.toDto(competition.get());
    }

    @Override
    public ResponseEntity<?> createCompetitionCategory(CreateCompetitionCategories competitionCategories) {
        Competition competition = competitionMapper.toEntity(competitionCategories.getCompetitionDto());

        for(LevelDto l : competitionCategories.getLevels()){
            Level level = levelMapper.toEntity(l);
            for (GenderDto g : competitionCategories.getGenders()){
                Gender gender = genderMapper.toEntity(g);
                for (GenerationDto gen : competitionCategories.getGenerations()){
                    Generation generation = generationMapper.toEntity(gen);
                    CompetitionCategory competitionCategory = CompetitionCategory.builder()
                            .level(level)
                            .gender(gender)
                            .generation(generation)
                            .competition(competition)
                            .build();

                    competitionCategoryRepository.save(competitionCategory);
                }
            }
        }

        return ResponseEntity.ok("succes");
    }
}
