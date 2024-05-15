package com.example.Thetossofcoin.services;

import com.example.Thetossofcoin.models.dtos.GenerationDto;
import com.example.Thetossofcoin.models.dtos.StudentDto;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);
    GenerationDto defineStudentGeneration(int yearOfBirth);
    ResponseEntity<?> addStudentToCompetition(Long studentId, Long competitionId);
}
