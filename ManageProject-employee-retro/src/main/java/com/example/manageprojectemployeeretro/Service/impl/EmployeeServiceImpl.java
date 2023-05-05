package com.example.manageprojectemployeeretro.Service.impl;

import com.example.manageprojectemployeeretro.Entity.Employee;
import com.example.manageprojectemployeeretro.Service.EmployeeService;
import com.example.manageprojectemployeeretro.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public void processOAuthPostLogin(String email) {
        User existUser = userRepository.getUserBymail(email);

        if (existUser == null) {
            User newUser = new User();
            newUser.setEmail(email);

            userRepository.save(newUser);

            System.out.println("Created new user: " + email);
        }

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void removeEmployeeById(int id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Optional<Employee> getEmployeeById(String id) {

        return employeeRepository.findEmployeeByEmail(id);
    }

    @Override
    public Optional<Employee> getEmployeeByEmail(String email) {


        return employeeRepository.findEmployeeByEmail(email);
    }

    public boolean checkLogin(String email, String pass) {
        Optional<User> optionalUser = getUserById(email);
        if(optionalUser.isPresent() && optionalUser.get().getPass().equals(pass)){
            return  true;
        }
        return false;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

}
