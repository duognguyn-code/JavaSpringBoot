package com.example.manageprojectemployeeretro.controller;


import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.service.UserService;
import com.example.manageprojectemployeeretro.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login/authen")
    public String LoginAuthen(@RequestParam("email")String email,
                        @RequestParam("password") String password,Model model){
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user != null){
            return "redirect:/home";
        }else{
            model.addAttribute("ERROR", Constants.ERROR);
            return "redirect:/login";
        }

    }
    @GetMapping("/home")
    public String welcomePage(Model model){
        return "home";
    }

}
