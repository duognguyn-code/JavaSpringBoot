package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.dto.EmployeeResponse;
import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    User findUserById(int id);


    Boolean existsUserByUsername(String username);
    User findByCode(Integer code);
    User findUserByUsername(@Param("username") String username);


    User findByEmailAndCode(String email, Integer code);
    User findByEmailAndPassword(String email, String password);
    @Query("SELECT u FROM User u WHERE u.email = :emailSI")
    User getUserBymail(@Param("emailSI") String email);

    List<User> findUserByProjects(Long projectId);

    List<User> findByProjects(Project project);

//     12.4 Customizing the Result with Class Constructors
    @Query("SELECT new com.example.manageprojectemployeeretro.entity.User(e.id, e.firstName, e.lastName, e.email, e.password, e.phone,  e.projects) FROM User e")
    List<User> getAllUser();

    Page<User> findAll(Pageable pageable);

//    @Query("select distinct u.email from User u Left JOIN  Timekeeping t on u.id = t.idUser.id where t.createAt = ?1 and t.checkin is null")
//    List<String> listEmpNotCheckin(Date date);
//
//    @Query("select distinct u.email from User u Left JOIN  Timekeeping t on u.id = t.idUser.id where t.createAt = ?1 and t.checkout is null")
//    List<String> listEmpNotCheckOut(Date date);

//    @Query(value = "SELECT NEW com.example.manageprojectemployeeretro.dto.EmployeeResponse(u.id, u.username, t.checkin, t.checkout, t.createAt) FROM User u JOIN Timekeeping t ON u.id = t.idUser.id WHERE EXTRACT(MONTH FROM t.createAt) = ?1 AND t.idUser.id = ?2 AND (t.checkin > '08:30:00' OR t.checkout IS NULL OR t.checkin IS NULL)")
//    List<EmployeeResponse> findUserNotCheckinOrErrorByEMP(Integer month, Long idUser);
}
