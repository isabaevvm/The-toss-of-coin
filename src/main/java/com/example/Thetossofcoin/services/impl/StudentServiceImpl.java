package com.example.Thetossofcoin.services.impl;

import com.example.Thetossofcoin.dao.*;
import com.example.Thetossofcoin.mappers.CompetitionCategoryMapper;
import com.example.Thetossofcoin.mappers.CompetitionLimitMapper;
import com.example.Thetossofcoin.mappers.LevelMapper;
import com.example.Thetossofcoin.mappers.StudentMapper;
import com.example.Thetossofcoin.models.dtos.CompetitionCategoryDto;
import com.example.Thetossofcoin.models.dtos.GenerationDto;
import com.example.Thetossofcoin.models.dtos.StudentDto;
import com.example.Thetossofcoin.models.entities.*;
import com.example.Thetossofcoin.services.GenerationService;
import com.example.Thetossofcoin.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final GenerationService generationService;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final CompetitionLimitRepository competitionLimitRepository;
    private final CompetitionLimitMapper competitionLimitMapper;
    private final CompetitionCategoryRepository categoryRepository;
    private final CompetitionCategoryMapper categoryMapper;
    private final CompetitionStudentRepository competitionStudentRepository;
    private final CompetitionRepository competitionRepository;
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
                return generationService.findByValue("дети");
            }

            if (yearOfBirth == 2010 || yearOfBirth == 2011 || yearOfBirth == 2012) {
                return generationService.findByValue("кадеты");
            }

            if (yearOfBirth == 2007 || yearOfBirth == 2008 || yearOfBirth == 2009) {
                return generationService.findByValue("юниоры");
            }

            return generationService.findByValue("взрослые");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> addStudentToCompetition(Long studentId, Long competitionId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new NullPointerException("такого студента не существует"));
        StudentDto studentDto = studentMapper.toDto(student);

        Level level = student.getLevel();
        Gender gender = student.getGender();
        Generation generation = student.getGeneration();

        Competition competition = competitionRepository.findById(competitionId).orElseThrow(() -> new NullPointerException("Такой соревновании не существует"));
        CompetitionCategory category = categoryRepository.findByCompetitionAndCategories(competition, level, gender, generation).orElseThrow(() -> new NullPointerException("такой категории не существует"));
        CompetitionCategoryDto categoryDto = categoryMapper.toDto(category);

        CompetitionLimit limit = competitionLimitRepository.findByCompetitionCategoryAndWeight(category, student.getWeight()).orElseThrow(() -> new RuntimeException("Студент не подходит ни к одной субкатегорию в этой соревновании"));

        CompetitionStudent competitionStudent = CompetitionStudent.builder()
                .competitionLimit(limit)
                .student(student)
                .build();

        return ResponseEntity.ok(competitionStudentRepository.save(competitionStudent));
    }
}
