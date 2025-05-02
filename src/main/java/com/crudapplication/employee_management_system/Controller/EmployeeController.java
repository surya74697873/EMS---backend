package com.crudapplication.employee_management_system.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudapplication.employee_management_system.Exception.ResourceNotFoundException;
import com.crudapplication.employee_management_system.Model.EmployeeDTO;
import com.crudapplication.employee_management_system.Service.EmployeeService;


// http://localhost:8374/
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeesDTOs(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.FOUND);
    }

    @GetMapping("/{emp_id}")
    public ResponseEntity<EmployeeDTO> getEmployeeDTOById(@PathVariable int emp_id) throws ResourceNotFoundException{
        return new ResponseEntity<>(employeeService.getEmployeeById(emp_id),HttpStatus.FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<List<EmployeeDTO>> addEmployeeDTO(@RequestBody EmployeeDTO employeeDTO) throws Exception{
        employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.ACCEPTED);

    }

    @PutMapping("/{emp_id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeDTO(@PathVariable int emp_id, @RequestBody EmployeeDTO employeeDTO) throws ResourceNotFoundException{
        return new ResponseEntity<>(employeeService.updateEmployee(emp_id, employeeDTO),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{emp_id}")
    public ResponseEntity<?> deleteEmployeeDTO(@PathVariable int emp_id) throws ResourceNotFoundException{
        
        if(employeeService.deleteEmployee(emp_id))
            return new ResponseEntity<>(new EmployeeDTO(), HttpStatus.ACCEPTED);

        throw new ResourceNotFoundException("The Id : "+ emp_id + " is not found");
    }

}


/*
 * name = root , password = jeni
 */