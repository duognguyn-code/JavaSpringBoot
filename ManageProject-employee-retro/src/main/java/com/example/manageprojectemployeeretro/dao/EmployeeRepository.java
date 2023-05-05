package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByEmail(String email);

    @Query("SELECT u FROM employee u WHERE u.email = :email")
    public Employee getEmployeeBymail(@Param("email") String email);
}
