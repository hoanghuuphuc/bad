package com.example.tfttournament.model;

import com.example.tfttournament.DTO.GenderTarget;
import com.example.tfttournament.DTO.MatchStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "court_name", nullable = false, length = 255)
    private String courtName;

    @Column(name = "match_date", nullable = false)
    private LocalDate matchDate;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender_target", nullable = false, length = 20)
    private GenderTarget genderTarget;

    @Column(name = "male_quantity")
    private Integer maleQuantity;

    @Column(name = "female_quantity")
    private Integer femaleQuantity;

    @Column(name = "male_deposit_k")
    private Integer maleDepositK;

    @Column(name = "female_deposit_k")
    private Integer femaleDepositK;

    @Column(name = "contact_phone", length = 20)
    private String contactPhone;

    @Column(name = "content", columnDefinition = "NVARCHAR(MAX)")
    private String content;

    @Column(name = "note", columnDefinition = "NVARCHAR(MAX)")
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private MatchStatus status = MatchStatus.OPEN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatchSkillLevel> skillLevels = new ArrayList<>();

    public void addSkillLevel(MatchSkillLevel skillLevel) {
        this.skillLevels.add(skillLevel);
        skillLevel.setMatch(this);
    }

    public void clearSkillLevels() {
        for (MatchSkillLevel skillLevel : skillLevels) {
            skillLevel.setMatch(null);
        }
        skillLevels.clear();
    }
}