package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}