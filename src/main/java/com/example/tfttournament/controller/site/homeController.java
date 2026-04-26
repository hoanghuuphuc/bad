package com.example.tfttournament.controller.site;

import com.example.tfttournament.dao.MatchDao;
import com.example.tfttournament.model.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class homeController {

    private final MatchDao matchDao;

    @RequestMapping("/")
  public String Home(Model m){
        List<Match> matches = matchDao.findAll();
        m.addAttribute("matches",matches);
        m.addAttribute("activeTab","keo");

      return "site/pages/index";
  }

}
