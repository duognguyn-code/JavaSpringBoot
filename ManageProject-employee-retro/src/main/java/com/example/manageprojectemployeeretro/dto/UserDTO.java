package com.example.manageprojectemployeeretro.dto;


import com.example.manageprojectemployeeretro.entity.User;
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
    public String firstName;
    public String lastName;
    public String email;
    private String password;
    private String role;
    public String phone;
    private long roleId;
    private String roleName;
    private List<Integer> commentIds;
    private long projectId;

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.roleName = user.getRole() != null ? user.getRole().getName() : null;
    }
}
