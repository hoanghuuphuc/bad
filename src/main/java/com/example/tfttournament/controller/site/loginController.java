package com.example.tfttournament.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller

public class loginController {

    @RequestMapping("auth/signin")
    public String login(){

        return "site/pages/login";
    }


}
