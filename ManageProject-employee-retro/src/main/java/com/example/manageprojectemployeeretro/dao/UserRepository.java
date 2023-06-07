package com.example.manageprojectemployeeretro.dao;

import com.example.manageprojectemployeeretro.entity.User;
import com.example.manageprojectemployeeretro.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(int id);

    User findUserByEmail(String email);
    User findUserByFirstName(String FirstName);


    User findByEmailAndPassword(String email, String password);
    @Query("SELECT u FROM User u WHERE u.email = :emailSI")
    User getUserBymail(@Param("emailSI") String email);

    List<User> findUserByProjects(Long projectId);

    List<User> findByProjects(Project project);

//     12.4 Customizing the Result with Class Constructors
    @Query("SELECT new com.example.manageprojectemployeeretro.entity.User(e.firstName, e.lastName,e.email ) FROM User e")
    List<User> getAllUser();

    @Modifying
    @Query(
            value =
                    "insert into User (firstName, lastName, password, phone,role, projects) values (:firstName, :lastName,:password, :phone, :role, :projects)",
            nativeQuery = true)
    void insertUser(@Param("firstName") String firstName, @Param("lastName") String lastName,@Param("password") String password, @Param("phone") String phone,
                    @Param("role") Integer role, @Param("projects") Integer projects);
}
