package com.example.Thetossofcoin.models.dtos;

import com.example.Thetossofcoin.models.entities.Coach;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDto {
    private Long id;
    private String competitionName;
    private Date deadline;
    private Date dateFrom;
    private Date dateTo;
    private CoachDto coachDto;
}
