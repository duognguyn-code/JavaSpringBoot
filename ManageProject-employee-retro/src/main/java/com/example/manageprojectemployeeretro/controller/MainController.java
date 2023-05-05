package com.example.manageprojectemployeeretro.controller;

//import com.example.manageprojectemployeeretro.utils.WebUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.security.core.Authentication;


import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/login")
    public String Login(Model model){
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "Login";
    }

    @GetMapping("/home")
    public String welcomePage(Model model){
        return "home";
    }

}
