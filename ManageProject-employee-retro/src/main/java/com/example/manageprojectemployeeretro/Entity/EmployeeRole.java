package com.example.manageprojectemployeeretro.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "employee_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRole {
    @EmbeddedId
    private EmployeeRoleId id;

    @ManyToOne
    @MapsId("employeeId")
    private Employee employee;

    @ManyToOne
    @MapsId("roleId")
    private Role role;
}
