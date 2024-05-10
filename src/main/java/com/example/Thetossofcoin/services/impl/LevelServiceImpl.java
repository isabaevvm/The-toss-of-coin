package com.example.Thetossofcoin.services.impl;

import com.example.Thetossofcoin.dao.LevelRepository;
import com.example.Thetossofcoin.mappers.LevelMapper;
import com.example.Thetossofcoin.models.dtos.LevelDto;
import com.example.Thetossofcoin.models.entities.Level;
import com.example.Thetossofcoin.services.LevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {
    private final static Logger log = LoggerFactory.getLogger(LevelServiceImpl.class.getName());

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private LevelMapper levelMapper;

    @Override
    public LevelDto findById(Long levelId) {
        log.info("Call method findById: levelId = {}", levelId);
        Optional<Level> level = levelRepository.findById(levelId);

        if (level.isEmpty()) throw new NoSuchElementException("Такого уровена не существует");
        LevelDto dto = levelMapper.toDto(level.get());
        return dto;
    }
}
