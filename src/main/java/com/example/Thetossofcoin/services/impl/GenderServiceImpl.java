package com.example.Thetossofcoin.services.impl;

import com.example.Thetossofcoin.dao.GenderRepository;
import com.example.Thetossofcoin.mappers.GenderMapper;
import com.example.Thetossofcoin.models.dtos.GenderDto;
import com.example.Thetossofcoin.models.entities.Gender;
import com.example.Thetossofcoin.services.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private GenderMapper genderMapper;

    @Override
    public GenderDto findById(Long genderId) {
        Optional<Gender> gender = genderRepository.findById(genderId);
        if (gender.isEmpty()) throw new NoSuchElementException("Такого пола не существует");
        return genderMapper.toDto(gender.get());
    }
}
