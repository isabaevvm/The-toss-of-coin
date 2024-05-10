package com.example.Thetossofcoin.services.impl;

import com.example.Thetossofcoin.dao.CoachRepository;
import com.example.Thetossofcoin.exceptions.CoachNotFoundException;
import com.example.Thetossofcoin.exceptions.StudentYearNotCorrectException;
import com.example.Thetossofcoin.exceptions.TokenWrongException;
import com.example.Thetossofcoin.mappers.CoachMapper;
import com.example.Thetossofcoin.models.dtos.*;
import com.example.Thetossofcoin.models.entities.Coach;
import com.example.Thetossofcoin.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachMapper coachMapper;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private GenderService genderService;

    @Autowired
    private LevelService levelService;

    @Autowired
    private GenerationService generationService;

    @Autowired
    private StudentService studentService;

    @Override
    public CoachDto saveCoach(CoachDto coachDto) {
        Coach savedCoach = coachRepository.save(coachMapper.coachDtoToCoach(coachDto));
        return coachMapper.coachToDto(savedCoach);
    }

    @Override
    public CoachDto findByEmail(String email) {
        Optional<Coach> coach = coachRepository.findByEmail(email);
        if (coach.isEmpty()) throw new CoachNotFoundException("Тренер с таким email не найден");
        return coachMapper.coachToDto(coach.get());
    }

    @Override
    public CoachDto findById(Long coachId) {
        Optional<Coach> coach = coachRepository.findById(coachId);
        if (coach.isEmpty()) throw new CoachNotFoundException("Тренер с таким id не найден");
        return coachMapper.coachToDto(coach.get());
    }

    @Override
    public String generateToken(CoachDto coachDto) {
        if (coachDto == null) throw new RuntimeException("Тренер не найден");

        String token = String.valueOf(UUID.randomUUID());
        coachDto.setToken(token);

        return saveCoach(coachDto).getToken();
    }

    @Override
    public boolean updateToken(CoachDto coachDto) {
        return false;
    }

    @Override
    public boolean checkToken(CoachDto coachDto, String token) {
        if (!coachDto.getToken().equals(token)) throw new TokenWrongException("Токен неправильный");
        return true;
    }

    @Override
    public StudentDto createNewStudent(String studentName, int yearOfBirth, int weight, int height, Long genderId, Long levelId, Long coachId) {
        String refactoredStudentName = studentName.strip();

        int currentYear = Year.now().getValue();
        if (yearOfBirth >= currentYear) throw new StudentYearNotCorrectException("Год рождение не может быть равен или больше к текущему году");

        LevelDto level = levelService.findById(levelId);
        GenderDto gender = genderService.findById(genderId);
        GenerationDto generation = studentService.defineStudentGeneration(yearOfBirth);

        StudentDto studentDto = StudentDto.builder()
                .studentName(refactoredStudentName)
                .yearOfBirth(yearOfBirth)
                .weight(weight)
                .height(height)
                .genderDto(gender)
                .levelDto(level)
                .generationDto(generation)
                .coachDto(findById(coachId))
                .build();

        StudentDto savedStudent = studentService.saveStudent(studentDto);
        return savedStudent;
    }
}
