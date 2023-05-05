package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.Entity.EmployeeRole;
import com.example.manageprojectemployeeretro.Entity.EmployeeRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, EmployeeRoleId> {
}
