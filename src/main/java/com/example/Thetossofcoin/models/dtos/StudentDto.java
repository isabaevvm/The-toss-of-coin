package com.example.Thetossofcoin.models.dtos;

import com.example.Thetossofcoin.models.entities.Gender;
import com.example.Thetossofcoin.models.entities.Generation;
import com.example.Thetossofcoin.models.entities.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String studentName;
    private Integer yearOfBirth;
    private Integer weight;
    private Integer height;
    private GenderDto genderDto;
    private LevelDto levelDto;
    private GenerationDto generationDto;
    private CoachDto coachDto;
}
