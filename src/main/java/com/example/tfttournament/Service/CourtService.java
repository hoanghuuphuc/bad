package com.example.tfttournament.Service;

import com.example.tfttournament.model.Court;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourtService  {
    List<Court> findAll();
}
