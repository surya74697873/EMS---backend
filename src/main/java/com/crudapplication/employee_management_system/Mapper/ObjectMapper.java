package com.crudapplication.employee_management_system.Mapper;

import com.crudapplication.employee_management_system.Model.Branch;
import com.crudapplication.employee_management_system.Model.Department;
import com.crudapplication.employee_management_system.Model.Employee;
import com.crudapplication.employee_management_system.Model.EmployeeDTO;

public class ObjectMapper {
    
    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
            employeeDTO.getId(),
            employeeDTO.getFullName(),
            employeeDTO.getEmail(),
            new Department(0,employeeDTO.getDepartmentName()),
            new Branch(0,employeeDTO.getBranchName())
        );
    }

    public static EmployeeDTO mapToEmployeeDTO(Employee employee){
        return new EmployeeDTO(
            employee.getId(),
            employee.getFullName(),
            employee.getEmail(),
            employee.getDepartment().getDepartmentName(),
            employee.getBranch().getBranchName()
        );
    }
}
