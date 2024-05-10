package com.example.Thetossofcoin.services.impl;

import com.example.Thetossofcoin.dao.StudentRepository;
import com.example.Thetossofcoin.mappers.StudentMapper;
import com.example.Thetossofcoin.models.dtos.GenerationDto;
import com.example.Thetossofcoin.models.dtos.StudentDto;
import com.example.Thetossofcoin.models.entities.Student;
import com.example.Thetossofcoin.services.GenerationService;
import com.example.Thetossofcoin.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final GenerationService generationService;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final static Logger log = LoggerFactory.getLogger(LevelServiceImpl.class.getName());


    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        if (studentDto == null) throw new NoSuchElementException("Студент пустой");
        Student savedStudent = studentRepository.save(studentMapper.toEntity(studentDto));
        return studentMapper.toDto(savedStudent);
    }

    @Override
    public GenerationDto defineStudentGeneration(int yearOfBirth) {
        try {
            if (yearOfBirth >= 2013) {
                return generationService.findByValue("Юноша");
            }

            if (yearOfBirth == 2010 || yearOfBirth == 2011 || yearOfBirth == 2012) {
                return generationService.findByValue("Кадет");
            }

            if (yearOfBirth == 2007 || yearOfBirth == 2008 || yearOfBirth == 2009) {
                return generationService.findByValue("Юниор");
            }

            return generationService.findByValue("Взрослый");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
