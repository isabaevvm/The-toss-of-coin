package com.example.Thetossofcoin.mappers;

import com.example.Thetossofcoin.models.dtos.StudentDto;
import com.example.Thetossofcoin.models.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {GenerationMapper.class, GenderMapper.class, LevelMapper.class, CoachMapper.class})
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "student.generation", target = "generationDto")
    @Mapping(source = "student.gender", target = "genderDto")
    @Mapping(source = "student.level", target = "levelDto")
    @Mapping(source = "student.coach", target = "coachDto")
    StudentDto toDto(Student student);

    @Mapping(source = "studentDto.generationDto", target = "generation")
    @Mapping(source = "studentDto.genderDto", target = "gender")
    @Mapping(source = "studentDto.levelDto", target = "level")
    @Mapping(source = "studentDto.coachDto", target = "coach")
    Student toEntity(StudentDto studentDto);
}
