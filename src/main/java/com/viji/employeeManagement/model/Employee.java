package com.viji.employeeManagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int eid;
    private String firstName;
    private String lastName;
    @Column(name = "Email")
    private String emailId;

}
