package com.example.manageprojectemployeeretro.mapper;

import com.example.manageprojectemployeeretro.dto.ProjectDTO;
import com.example.manageprojectemployeeretro.entity.Project;
import com.example.manageprojectemployeeretro.utils.EntityMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProjectMapper extends EntityMapper<ProjectDTO, Project> {
}
