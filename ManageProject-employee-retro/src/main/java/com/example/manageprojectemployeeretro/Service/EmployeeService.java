package com.example.manageprojectemployeeretro.Service;

import com.example.manageprojectemployeeretro.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    void removeEmployeeById(int id);

    Optional<Employee> getEmployeeById(String id);

    Optional<Employee> getEmployeeByEmail(String email);

    boolean checkLogin(String email, String pass);
}
