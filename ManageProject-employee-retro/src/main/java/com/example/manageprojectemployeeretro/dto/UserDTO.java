package com.example.manageprojectemployeeretro.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
}
