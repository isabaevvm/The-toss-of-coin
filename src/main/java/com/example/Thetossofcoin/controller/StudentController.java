package com.example.Thetossofcoin.controller;

import com.example.Thetossofcoin.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/addStudentToCompetition")
    public ResponseEntity<?> addStudentToCompetition(@RequestParam Long studentId, @RequestParam Long competitionId){
        return studentService.addStudentToCompetition(studentId, competitionId);
    }
}
