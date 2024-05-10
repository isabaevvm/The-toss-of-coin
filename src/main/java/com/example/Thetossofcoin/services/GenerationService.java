package com.example.Thetossofcoin.services;

import com.example.Thetossofcoin.models.dtos.GenerationDto;

public interface GenerationService {
    GenerationDto findByValue(String value);
}
