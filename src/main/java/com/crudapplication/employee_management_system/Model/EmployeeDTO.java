package com.crudapplication.employee_management_system.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    
    private int id;

    private String fullName;

    private String email;

    private String departmentName;

    private String branchName;

}
