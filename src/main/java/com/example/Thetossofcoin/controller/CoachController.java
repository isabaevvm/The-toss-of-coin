package com.example.Thetossofcoin.controller;

import com.example.Thetossofcoin.models.dtos.CoachDto;
import com.example.Thetossofcoin.services.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coach")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService coachService;

    @PostMapping("/createNewStudent")
    public ResponseEntity<?> createNewStudent(@RequestParam String studentName, @RequestParam int yearOfBirth,
                                              @RequestParam int weight, @RequestParam int height,
                                              @RequestParam Long genderId, @RequestParam Long levelId, @RequestParam Long coachId) {

        return ResponseEntity.ok(coachService.createNewStudent(studentName, yearOfBirth, weight, height, genderId, levelId, coachId));
    }

    @GetMapping("/byId/{id}")
    public CoachDto byId(@PathVariable Long id){
        return coachService.findById(id);
    }
}
