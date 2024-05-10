package com.example.Thetossofcoin.mappers;

import com.example.Thetossofcoin.models.dtos.CoachDto;
import com.example.Thetossofcoin.models.entities.Coach;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CoachMapper {
    CoachMapper INSTANCE = Mappers.getMapper(CoachMapper.class);


    CoachDto coachToDto(Coach coach);

    Coach coachDtoToCoach(CoachDto coachDto);
}
