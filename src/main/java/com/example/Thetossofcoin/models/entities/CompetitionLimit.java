package com.example.Thetossofcoin.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "competition_limits")
public class CompetitionLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer heightFrom;
    private Integer heightTo;

    private Integer weightFrom;
    private Integer weightTo;

    @ManyToOne
    @JoinColumn(name = "competition_category_id", referencedColumnName = "id")
    private CompetitionCategory competitionCategory;
}
