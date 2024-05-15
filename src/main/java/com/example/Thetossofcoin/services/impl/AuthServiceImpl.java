package com.example.Thetossofcoin.services.impl;

import com.example.Thetossofcoin.exceptions.RegistrationException;
import com.example.Thetossofcoin.models.dtos.CoachDto;
import com.example.Thetossofcoin.services.AuthService;
import com.example.Thetossofcoin.services.CoachService;
import com.example.Thetossofcoin.utils.HashingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private HashingService hashingService;

    @Autowired
    private CoachService coachService;

    @Override
    public CoachDto registerNewCoach(String email, String password) {
        if (email == null || password == null)
            throw new RegistrationException("Ошибка при регистрации, проверьте правильность данные и повторите попытку");

        CoachDto coachDto = CoachDto.builder()
                .email(email)
                .password(hashingService.hashString(password))
                .build();

        return coachService.saveCoach(coachDto);
    }

    @Override
    public ResponseEntity<?> loginWithPassword(String password, String email) {
        CoachDto coachDto = coachService.findByEmail(email);

        String hashedPassword = hashingService.hashString(password);
        boolean isPasswordEqual = coachDto.getPassword().equals(hashedPassword);

        if (!isPasswordEqual) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Пароль неправильный, повторите попытку");
        }

        return ResponseEntity.ok(coachDto);
    }

}
