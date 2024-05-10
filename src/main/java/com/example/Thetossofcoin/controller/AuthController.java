package com.example.Thetossofcoin.controller;

import com.example.Thetossofcoin.services.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerNewCoach(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(authService.registerNewCoach(email, password));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginWithPassword(@RequestHeader String password, @RequestParam String email) {
        return authService.loginWithPassword(password, email);
    }
}
