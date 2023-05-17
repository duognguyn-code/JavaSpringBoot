package com.example.manageprojectemployeeretro.controller;

//import com.example.manageprojectemployeeretro.utils.WebUtils;

import com.example.manageprojectemployeeretro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.security.core.Authentication;


@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String Login(){
//        model.addAttribute("title", "Welcome");
//        model.addAttribute("message", "This is welcome page!");
        return "Login";
    }
    @PostMapping("/login/authen")
    public String LoginAuthen(@RequestParam("email")String email,
                        @RequestParam("password") String password,Model model){
        if(userService.checkLogin(email, password)){
            return "redirect:/api/users/listUser";
        }else{
            model.addAttribute("ERROR","Sai tên đăng nhập Hoặc mật khẩu ");
            return "redirect:/api/users/listUser";
        }

    }
    @GetMapping("/home")
    public String welcomePage(Model model){
        return "home";
    }

}
