package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.dao.UserRepository;
import com.example.manageprojectemployeeretro.dto.ProjectProjection;
import com.example.manageprojectemployeeretro.entity.Project;

import com.example.manageprojectemployeeretro.service.ProjectService;
import com.example.manageprojectemployeeretro.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private  ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    //    public ProjectDTO createProject(ProjectDTO projectDTO) {
//        Project project = ProjectMapper.INSTANCE.projectDtoToProject(projectDTO);
//        User user = userRepository.findUserByFirstName(projectDTO.getUserName());
//        project.setUser((List<User>) user);
//        Project savedProject = projectRepository.save(project);
//        return ProjectMapper.INSTANCE.projectToProjectDTO(savedProject);
//    }

    @Override
    public List<Project> getAllProJect() {
        return projectRepository.findAll();
    }

    @Override
    public Project findProjectById(long id) {
        return projectRepository.getProjectById(id);

    }

//    public List<ProjectProjection> findProjectByName(String name) {
//        return projectRepository.findByName(name);
//    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProjectById(long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<ProjectProjection> findProjectsByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public Page<Project> getAllUsers(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }
}
