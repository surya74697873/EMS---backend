package com.crudapplication.employee_management_system.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapplication.employee_management_system.Model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer>{
    
    public Optional<Branch> findBybranchName(String branchName);
    
}
