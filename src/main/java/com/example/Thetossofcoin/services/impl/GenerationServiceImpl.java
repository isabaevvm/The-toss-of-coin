package com.example.Thetossofcoin.services.impl;

import com.example.Thetossofcoin.dao.GenerationRepository;
import com.example.Thetossofcoin.mappers.GenerationMapper;
import com.example.Thetossofcoin.models.dtos.GenerationDto;
import com.example.Thetossofcoin.models.entities.Generation;
import com.example.Thetossofcoin.services.GenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenerationServiceImpl implements GenerationService {

    private final GenerationRepository generationRepository;
    private final GenerationMapper generationMapper;

    @Override
    public GenerationDto findByValue(String value) {
        Optional<Generation> generation = generationRepository.findByValue(value);
        if (generation.isEmpty()) throw new NoSuchElementException(String.format("Такой категории; '%s' не существует", value));
        return generationMapper.toDto(generation.get());
    }
}
