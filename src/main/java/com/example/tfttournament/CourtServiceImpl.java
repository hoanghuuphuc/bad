package com.example.tfttournament;

import com.example.tfttournament.Service.CourtService;
import com.example.tfttournament.dao.CourtDao;
import com.example.tfttournament.model.Court;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtServiceImpl implements CourtService {
    @Autowired
    CourtDao courtDao;

    @Override
    public List<Court> findAll() {
        return courtDao.findAll();
    }
}
