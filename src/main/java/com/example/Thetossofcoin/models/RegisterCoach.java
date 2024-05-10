package com.example.Thetossofcoin.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RegisterCoach {
    private String email;
    private String password;
}
