package com.example.tfttournament.model;

import com.example.tfttournament.DTO.GenderType;
import com.example.tfttournament.DTO.SkillLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "match_skill_levels",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_match_gender_level",
                        columnNames = {"match_id", "gender_type", "skill_level"}
                )
        }
)
@Getter
@Setter
public class MatchSkillLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender_type", nullable = false, length = 20)
    private GenderType genderType;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_level", nullable = false, length = 20)
    private SkillLevel skillLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;
}