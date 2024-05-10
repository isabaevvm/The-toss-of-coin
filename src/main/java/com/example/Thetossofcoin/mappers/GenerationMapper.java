package com.example.Thetossofcoin.mappers;

import com.example.Thetossofcoin.models.dtos.GenerationDto;
import com.example.Thetossofcoin.models.entities.Generation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GenerationMapper {
    GenerationMapper INSTANCE = Mappers.getMapper(GenerationMapper.class);

    GenerationDto toDto(Generation generation);
    Generation toEntity(GenerationDto generationDto);
}
