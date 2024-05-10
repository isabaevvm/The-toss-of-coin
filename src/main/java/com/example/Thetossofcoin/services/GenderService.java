package com.example.Thetossofcoin.services;

import com.example.Thetossofcoin.models.dtos.GenderDto;

public interface GenderService {
    GenderDto findById(Long genderId);
}
