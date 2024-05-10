package com.example.Thetossofcoin.controller;

import com.example.Thetossofcoin.models.CreateCompetitionCategories;
import com.example.Thetossofcoin.models.dtos.CompetitionDto;
import com.example.Thetossofcoin.services.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/competition")
@RequiredArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;

    @PostMapping("/createCompetition")
    public ResponseEntity<?> createCompetition(@RequestBody CompetitionDto competitionDto) {
        return ResponseEntity.ok(competitionService.saveCompetition(competitionDto));
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long competitionId){
        return ResponseEntity.ok(competitionService.findById(competitionId));
    }

    @PostMapping("/createCategories")
    public ResponseEntity<?> createCompetitionCategory(@RequestBody CreateCompetitionCategories competitionCategories){
        return ResponseEntity.ok(competitionService.createCompetitionCategory(competitionCategories));
    }
}
