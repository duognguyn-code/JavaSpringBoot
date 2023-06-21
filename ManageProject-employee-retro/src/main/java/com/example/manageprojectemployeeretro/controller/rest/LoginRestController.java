package com.example.manageprojectemployeeretro.controller.rest;

import com.example.manageprojectemployeeretro.dto.LoginRequest;
import com.example.manageprojectemployeeretro.dto.SignUpRequest;
import com.example.manageprojectemployeeretro.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class LoginRestController {
    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(  SignUpRequest signUpRequest) {
        return authService.registerUser(signUpRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @GetMapping("/main")
    public String viewMain(){
        return "admin/adminUser/user-list";
    }


}
