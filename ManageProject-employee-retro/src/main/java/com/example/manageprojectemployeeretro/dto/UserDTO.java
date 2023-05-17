package com.example.manageprojectemployeeretro.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    private String password;
    public String phone;
    private List<Integer> roleId;
    private List<Integer> commentIds;
    private List<Integer> projectId;

}
