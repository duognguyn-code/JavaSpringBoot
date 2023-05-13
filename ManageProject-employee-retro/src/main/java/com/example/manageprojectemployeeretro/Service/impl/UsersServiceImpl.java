package com.example.manageprojectemployeeretro.Service.impl;

import com.example.manageprojectemployeeretro.Entity.Employee;
import com.example.manageprojectemployeeretro.Service.EmployeeService;
import com.example.manageprojectemployeeretro.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void removeEmployeeById(int id) {

    }

    @Override
    public Optional<Employee> getEmployeeById(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Override
    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Override
    public boolean checkLogin(String email, String pass) {
        Optional<Employee> optionalEmployee = getEmployeeByEmail(email);
        if(optionalEmployee.isPresent() && optionalEmployee.get().getPassword().equals(pass)){
            return true;
        }
        return false;
    }
//    public void processOAuthPostLogin(String email) {
//        Employee existUser = employeeRepository.getEmployeeBymail(email);
//
//        if (existUser == null) {
//            Employee newUser = new Employee();
//            newUser.setEmail(email);
//
//            employeeRepository.save(newUser);
//
//            System.out.println("Created new user: " + email);
//        }
//
//    }
}

