package com.example.Thetossofcoin.mappers;

import com.example.Thetossofcoin.models.dtos.LevelDto;
import com.example.Thetossofcoin.models.entities.Level;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LevelMapper {
    LevelMapper INSTANCE = Mappers.getMapper(LevelMapper.class);

    LevelDto toDto(Level level);
    Level toEntity(LevelDto levelDto);
}
