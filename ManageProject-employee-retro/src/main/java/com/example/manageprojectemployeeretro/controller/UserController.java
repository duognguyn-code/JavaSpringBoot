package com.example.manageprojectemployeeretro.controller;

import com.example.manageprojectemployeeretro.Service.impl.ApiService;
import com.example.manageprojectemployeeretro.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("api/users")
public class UserController {
    private final RestTemplate restTemplate;

    @Autowired
    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private ApiService apiService;

    //    @GetMapping()
//    public String getUsers(Model model) {
//        String apiUrl = "https://63344d73433198e79dd52e49.mockapi.io/products";
//        UserDTO[] user = restTemplate.getForObject(apiUrl, UserDTO[].class);
//        model.addAttribute("users", user);
//        return "user-list";
//    }
    @GetMapping()
    public String getProductPage(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10") int pageSize,
                                 Model model) {
        List<UserDTO> users = apiService.getUsers(page, pageSize);
        model.addAttribute("users1", users);
        model.addAttribute("page", page);
        return "user-list";
    }
    @GetMapping("/viewcreate")
    public String pageCreate(Model model) {
        return "create-user";
    }

}
