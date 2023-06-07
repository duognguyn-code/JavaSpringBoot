package com.example.manageprojectemployeeretro.service.impl;

import com.example.manageprojectemployeeretro.dao.ProjectRepository;
import com.example.manageprojectemployeeretro.dto.UserDTO;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.entity.Project;

import com.example.manageprojectemployeeretro.even.UserCreatedEvent;
import com.example.manageprojectemployeeretro.service.UserService;
import com.example.manageprojectemployeeretro.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


//    private final UserMapper userMapper;
//
//    public UserServiceImpl(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
//    public UserDTO getUserDTO(User user) {
//        return userMapper.userToUserDTO(user);
//    }

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    @Autowired
    private UserRepository userDAO;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userDAO.findAll(pageable);
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.save(user);
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(this, user);
        eventPublisher.publishEvent(userCreatedEvent);
    }

    @Override
    public User findUserById(int id) {
        return userDAO.findUserById(id);
    }

    @Override
    public void deleteUserById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
       return userDAO.save(user);
    }


    @Override
    public void saveUser(List<User> users) {
        userDAO.saveAll(users);

    }

    @Override
    public Optional<User> getUserById(int id) {
        return null;
    }

    @Override
    public User getUserByEmail(String emailSI) {
        return userDAO.getUserBymail(emailSI);
    }

    @Override
    public boolean checkLogin(String email, String pass) {
        User optionalUser = userDAO.getUserBymail(email);
        if(optionalUser != null && optionalUser.getPassword().equals(pass)){
            return  true;
        }
        return false;
    }

    @Override
    public List<User> getUsersByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID: " + projectId));
        return userDAO.findByProjects(project);
    }

    public void processOAuthPostLogin(String email) {
        User existUser = userDAO.getUserBymail(email);

        if (existUser == null) {
            User newUser = new User();
            newUser.setEmail(email);

            userDAO.save(newUser);

            System.out.println("Created new user: " + email);
        }

    }
    public UserDTO mapUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setRoleName(user.getRole() != null ? user.getRole().getName() : null);

        return userDTO;
    }
}
