package com.crudapplication.employee_management_system.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.employee_management_system.Model.Department;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Integer> {
    
    public Optional<Department> findBydepartmentName(String department_name);

}
