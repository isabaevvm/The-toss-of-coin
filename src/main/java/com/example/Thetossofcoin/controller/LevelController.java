package com.example.Thetossofcoin.controller;

import com.example.Thetossofcoin.services.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/levels")
@RequiredArgsConstructor
public class LevelController {
    private final LevelService levelService;

    @GetMapping("/byId/{levelId}")
    public ResponseEntity<?> findById(@PathVariable Long levelId){
        return ResponseEntity.ok(levelService.findById(levelId));
    }
}
