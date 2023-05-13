package com.example.manageprojectemployeeretro;

import com.example.manageprojectemployeeretro.Entity.Comment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Persistent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class ManageProjectEmployeeRetroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageProjectEmployeeRetroApplication.class, args);
    }


}
