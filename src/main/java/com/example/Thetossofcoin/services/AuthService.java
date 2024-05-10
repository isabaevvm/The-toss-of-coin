package com.example.Thetossofcoin.services;

import com.example.Thetossofcoin.models.dtos.CoachDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    CoachDto registerNewCoach(String email, String password);

    ResponseEntity<?> loginWithPassword(String password, String email);
}
