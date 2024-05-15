package com.example.Thetossofcoin.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddLimitsForCompetitionCategory {
    private Integer heightFrom;
    private Integer heightTo;
    private Integer weightFrom;
    private Integer weightTo;
}
