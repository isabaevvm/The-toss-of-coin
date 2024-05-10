package com.example.Thetossofcoin.services;

import com.example.Thetossofcoin.models.dtos.CoachDto;
import com.example.Thetossofcoin.models.dtos.StudentDto;

public interface CoachService {
    CoachDto saveCoach(CoachDto coachDto);
    CoachDto findByEmail(String email);
    CoachDto findById(Long coachId);
    String generateToken(CoachDto coachDto);
    boolean updateToken(CoachDto coachDto);
    boolean checkToken(CoachDto coachDto, String token);
    StudentDto createNewStudent(String studentName, int yearOfBirth,
                                int weight, int height, Long genderId,
                                Long levelId, Long coachId);
}
