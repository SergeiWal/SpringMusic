package com.valko.SpringMusic.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
public class MainAppController {

    @GetMapping(value = "/")
    public String index(Model model){
        return "index";
    }

    @GetMapping(value = "/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration(Model model){
        return "registration";
    }

    @GetMapping(value = "/client")
    public String Client(Model model){
        return "client";
    }

    @GetMapping(value = "/admin")
    public String admin(Model model){
        return "admin";
    }
}
