package com.example.manageprojectemployeeretro.controller;

import com.example.manageprojectemployeeretro.entity.Project;
import com.example.manageprojectemployeeretro.entity.Role;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.service.ProjectService;
import com.example.manageprojectemployeeretro.service.RoleService;
import com.example.manageprojectemployeeretro.service.UserService;
import com.example.manageprojectemployeeretro.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
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
    private RoleService roleService;

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;


    @GetMapping("listUser")
    public String getAcc(@RequestParam(defaultValue = "0") int page, Model model){
        int pageSize = 10;
        Pageable pageable =  PageRequest.of(page, pageSize);
        Page<User> userPage = (Page<User>) userService.getAllUsers(pageable);
        model.addAttribute("userPage", userPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("roles", roleService.getAllRole());
        model.addAttribute("projects", projectService.getAllProJect());
        return "user-list";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUserById(id);
        return "redirect:/api/users/listUser";
    }
    @RequestMapping(value = "createUser",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String postUserAdd(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("phone") String phone,
                              @RequestParam("email") String email,
                              @RequestParam("password") String pass,
                              @RequestParam("roleId") String roleId,
                              @RequestParam("projectId") String projectId, UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        List<Role> roles = new ArrayList<>();
        for (Integer item: userDTO.getRoleId()){
            roles.add(roleService.findRoleById(item).get());
        }
        List<Project> projects = new ArrayList<>();
        for (Integer item: userDTO.getProjectId()){
            projects.add(projectService.findProjectById(item).get());
        }
        user.setProjects((Project) projects);
        userService.updateUser(user);
        return "redirect:/api/users/listUser";
    }
}
