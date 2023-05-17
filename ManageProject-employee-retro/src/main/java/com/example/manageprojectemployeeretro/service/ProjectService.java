package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAllProJect();

    Optional<Project> findProjectById(long id);
}
