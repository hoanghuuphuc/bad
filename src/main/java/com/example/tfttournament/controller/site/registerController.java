package com.example.tfttournament.controller.site;

import com.example.tfttournament.dao.AccountDao;
import com.example.tfttournament.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class registerController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    AccountDao AccD;

    @GetMapping("")
    public String Register(Model m){
        return "site/pages/register";
    }
    @PostMapping("")
        public String Register1(Model m, @RequestParam("account") String acc,
                                @RequestParam("password") String password){
        User user = new User();
        user.setUsername(acc);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        AccD.save(user);

            return "site/pages/register";
        }




}
