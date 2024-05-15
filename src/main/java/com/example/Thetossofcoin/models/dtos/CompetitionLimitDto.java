package com.example.Thetossofcoin.models.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionLimitDto {
    private Long id;
    private Integer heightFrom;
    private Integer heightTo;
    private Integer weightFrom;
    private Integer weightTo;
    private CompetitionCategoryDto competitionCategoryDto;
}
