package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.entity.Project;
import com.example.manageprojectemployeeretro.service.ProjectService;
import com.example.manageprojectemployeeretro.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public List<Project> getAllProJect() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findProjectById(long id) {
        return projectRepository.findById(id);
    }
}
