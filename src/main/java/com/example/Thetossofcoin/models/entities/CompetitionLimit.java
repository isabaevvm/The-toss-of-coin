package com.example.Thetossofcoin.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "competition_limits")
public class CompetitionLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private int height;
    private int weight;

    @ManyToOne
    @JoinColumn(name = "competition_category_id", referencedColumnName = "id")
    private CompetitionCategory competitionCategory;
}
