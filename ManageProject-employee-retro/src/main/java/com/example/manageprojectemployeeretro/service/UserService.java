package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
    void createUser(User user);

    User findUserById(int id);

//    User findUserByUserName(String userName);

    void deleteUserById(int id);
    User updateUser(User user);


    void saveUser(List<User> users);
        Optional<User> getUserById(int id);

    Optional<User> getUserByEmail(String email);

    boolean checkLogin(String email, String pass);
}
