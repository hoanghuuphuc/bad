package com.example.tfttournament.dao;

import com.example.tfttournament.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchDao extends JpaRepository<Match,Long> {
}
