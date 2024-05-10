package com.example.Thetossofcoin.mappers;

import com.example.Thetossofcoin.models.dtos.CompetitionCategoryDto;
import com.example.Thetossofcoin.models.entities.Competition;
import com.example.Thetossofcoin.models.entities.CompetitionCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LevelMapper.class, GenderMapper.class, GenerationMapper.class, CompetitionMapper.class})
public interface CompetitionCategoryMapper {

    @Mapping(source = "competitionCategory.level", target = "levelDto")
    @Mapping(source = "competitionCategory.gender", target = "genderDto")
    @Mapping(source = "competitionCategory.generation", target = "generationDto")
    @Mapping(source = "competitionCategory.competition", target = "competitionDto")
    CompetitionCategoryDto toDto(CompetitionCategory competitionCategory);

    @Mapping(source = "competitionCategoryDto.levelDto", target = "level")
    @Mapping(source = "competitionCategoryDto.genderDto", target = "gender")
    @Mapping(source = "competitionCategoryDto.generationDto", target = "generation")
    @Mapping(source = "competitionCategoryDto.competitionDto", target = "competition")
    CompetitionCategory toEntity(CompetitionCategoryDto competitionCategoryDto);
}
