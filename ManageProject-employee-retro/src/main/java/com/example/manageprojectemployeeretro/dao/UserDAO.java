package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.dto.UserDTO;

import java.util.List;

public interface UserDAO {
    public void save(UserDTO user);
    public void update(UserDTO user);
    public void delete(int email);
    public UserDTO get(int email);
    public List<UserDTO> list();
}
