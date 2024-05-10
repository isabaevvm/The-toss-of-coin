package com.example.Thetossofcoin.models.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoachDto {
    private Long id;
    private String coachName;
    private String email;
    private String password;
    private String token;
}
