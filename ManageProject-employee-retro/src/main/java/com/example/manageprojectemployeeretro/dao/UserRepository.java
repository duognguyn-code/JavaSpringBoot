package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(int id);
  
    User findUserByEmail(String email);



    User findByEmailAndPassword(String email, String password);
  
    @Query("SELECT u FROM User u WHERE u.email = :emailSI")
    User getUserBymail(@Param("emailSI") String email);



}
