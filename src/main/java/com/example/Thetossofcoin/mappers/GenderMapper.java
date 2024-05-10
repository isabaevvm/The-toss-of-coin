package com.example.Thetossofcoin.mappers;

import com.example.Thetossofcoin.models.dtos.GenderDto;
import com.example.Thetossofcoin.models.entities.Gender;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    GenderMapper INSTANCE = Mappers.getMapper(GenderMapper.class);

    GenderDto toDto(Gender gender);
    Gender toEntity(GenderDto genderDto);
}
