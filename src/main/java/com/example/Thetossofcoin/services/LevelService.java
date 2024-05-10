package com.example.Thetossofcoin.services;

import com.example.Thetossofcoin.models.dtos.LevelDto;

public interface LevelService {
    LevelDto findById(Long levelId);
}
