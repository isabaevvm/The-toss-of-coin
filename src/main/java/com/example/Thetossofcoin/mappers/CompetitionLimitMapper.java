package com.example.Thetossofcoin.mappers;

import com.example.Thetossofcoin.models.dtos.CompetitionLimitDto;
import com.example.Thetossofcoin.models.entities.CompetitionLimit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CompetitionCategoryMapper.class})
public interface CompetitionLimitMapper {

    @Mapping(source = "competitionLimit.competitionCategory", target = "competitionCategoryDto")
    CompetitionLimitDto toDto(CompetitionLimit competitionLimit);

    @Mapping(source = "competitionLimitDto.competitionCategoryDto", target = "competitionCategory")
    CompetitionLimit toEntity(CompetitionLimitDto competitionLimitDto);
}
