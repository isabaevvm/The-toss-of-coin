package com.example.Thetossofcoin.mappers;

import com.example.Thetossofcoin.models.dtos.CompetitionDto;
import com.example.Thetossofcoin.models.entities.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CoachMapper.class})
public interface CompetitionMapper {

    @Mapping(source = "competition.coach", target = "coachDto")
    CompetitionDto toDto(Competition competition);

    @Mapping(source = "competitionDto.coachDto", target = "coach")
    Competition toEntity(CompetitionDto competitionDto);
}
