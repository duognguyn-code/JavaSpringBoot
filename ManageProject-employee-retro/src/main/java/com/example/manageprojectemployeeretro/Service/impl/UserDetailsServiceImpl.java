package com.example.manageprojectemployeeretro.Service.impl;

import com.example.manageprojectemployeeretro.Entity.Employee;
import com.example.manageprojectemployeeretro.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepository.getEmployeeBymail(email);
        if (employee == null){
            throw new UsernameNotFoundException("Khum thấy");
        }
        return null;
    }
}
