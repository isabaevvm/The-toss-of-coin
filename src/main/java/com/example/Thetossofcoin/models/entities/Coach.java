package com.example.Thetossofcoin.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String coachName;

    @Column(unique = true)
    private String email;
    private String password;
    private String token;
}
