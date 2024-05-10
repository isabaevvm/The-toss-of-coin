package com.example.Thetossofcoin.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionCategoryDto {
    private Long id;
    private LevelDto levelDto;
    private GenderDto genderDto;
    private GenerationDto generationDto;
    private CompetitionDto competitionDto;
}
