package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
