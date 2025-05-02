package com.crudapplication.employee_management_system.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fullName;

    private String email;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Department department;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Branch branch;

}
