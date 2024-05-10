package com.example.Thetossofcoin.services;

import com.example.Thetossofcoin.models.dtos.GenerationDto;
import com.example.Thetossofcoin.models.dtos.StudentDto;

public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);

    GenerationDto defineStudentGeneration(int yearOfBirth);
}
