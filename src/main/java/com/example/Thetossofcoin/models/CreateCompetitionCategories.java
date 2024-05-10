package com.example.Thetossofcoin.models;

import com.example.Thetossofcoin.models.dtos.CompetitionDto;
import com.example.Thetossofcoin.models.dtos.GenderDto;
import com.example.Thetossofcoin.models.dtos.GenerationDto;
import com.example.Thetossofcoin.models.dtos.LevelDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompetitionCategories {
    private List<LevelDto> levels;
    private List<GenderDto> genders;
    private List<GenerationDto> generations;
    private CompetitionDto competitionDto;
}
