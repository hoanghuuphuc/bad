package com.example.tfttournament.controller.site;


import com.example.tfttournament.Service.CourtService;
import com.example.tfttournament.model.Court;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("court")
public class courtController {
    @Autowired
    CourtService courtService;


    @GetMapping("")
    public String count(Model m){
        m.addAttribute("activeTab", "court");
        List<Court> court =courtService.findAll();
        m.addAttribute("court",court);


        return "site/pages/badminton_court";
    }

}
