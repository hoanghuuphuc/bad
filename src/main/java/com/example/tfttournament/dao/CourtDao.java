package com.example.tfttournament.dao;

import com.example.tfttournament.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtDao extends JpaRepository<Court, String> {

}
