package com.crudapplication.employee_management_system.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crudapplication.employee_management_system.Exception.EmptyResourceFoundException;
import com.crudapplication.employee_management_system.Exception.ResourceNotFoundException;
import com.crudapplication.employee_management_system.Mapper.ObjectMapper;
import com.crudapplication.employee_management_system.Model.Branch;
import com.crudapplication.employee_management_system.Model.Department;
import com.crudapplication.employee_management_system.Model.Employee;
import com.crudapplication.employee_management_system.Model.EmployeeDTO;
import com.crudapplication.employee_management_system.Repository.BranchRepository;
import com.crudapplication.employee_management_system.Repository.DepartmentRespository;
import com.crudapplication.employee_management_system.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRespository departmentRespository;
    private BranchRepository branchRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRespository departmentRespository,BranchRepository branchRepository){
        this.employeeRepository = employeeRepository;
        this.departmentRespository = departmentRespository;
        this.branchRepository = branchRepository;
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();    
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        
        for(Employee employee : employees)
            employeeDTOs.add(ObjectMapper.mapToEmployeeDTO(employee));

        return employeeDTOs;
    }

    public EmployeeDTO getEmployeeById(int emp_id) throws ResourceNotFoundException{
        
        if(!employeeRepository.existsById(emp_id))
            throw new ResourceNotFoundException("The ID : " + emp_id + " is Not Available in Employee Respository");
            
        return ObjectMapper.mapToEmployeeDTO(employeeRepository.findById(emp_id).get());
    }

    public void addEmployee(EmployeeDTO employeeDTO) throws Exception{
        System.out.println("Added");
        if((employeeDTO == null )|| (employeeDTO.getFullName() == null && employeeDTO.getEmail() == null && employeeDTO.getDepartmentName() == null && employeeDTO.getBranchName() == null))
            throw new EmptyResourceFoundException("Resource is empty");

        Employee employee = ObjectMapper.mapToEmployee(employeeDTO);
        Department newDepartment = employee.getDepartment();
        Department existDepartment = departmentRespository.findBydepartmentName(newDepartment.getDepartmentName()).orElse(null);

        if(existDepartment != null)
            employee.setDepartment(existDepartment);

        Branch newBranch = employee.getBranch();
        Branch existBranch = branchRepository.findBybranchName(newBranch.getBranchName()).orElse(null);

        if(existBranch != null)
            employee.setBranch(existBranch);

        employeeRepository.save(employee);

    }

    public EmployeeDTO updateEmployee(int emp_id, EmployeeDTO employeeDTO) throws ResourceNotFoundException{

        if(!employeeRepository.existsById(emp_id))
            throw new ResourceNotFoundException("The ID : " + emp_id + " is Not Available in Employee Respository");

        Employee employee = ObjectMapper.mapToEmployee(employeeDTO);
        Employee existEmployee = employeeRepository.findById(emp_id).get();

        if(employee.getFullName() != null)
            existEmployee.setFullName(employee.getFullName());

        if(employee.getEmail() != null)
            existEmployee.setEmail(employee.getEmail());

        if(employee.getDepartment() != null && employee.getDepartment().getDepartmentName() != null)
            existEmployee.getDepartment().setDepartmentName(employee.getDepartment().getDepartmentName());

        if(employee.getBranch() != null && employee.getBranch().getBranchName() != null)
            existEmployee.getBranch().setBranchName(employee.getBranch().getBranchName());
            
        employeeRepository.save(existEmployee);

        return ObjectMapper.mapToEmployeeDTO(existEmployee);
    }

    public boolean deleteEmployee(int emp_id) throws ResourceNotFoundException {

        if(!employeeRepository.existsById(emp_id))
            throw new ResourceNotFoundException("The ID : " + emp_id + " is Not Available in Employee Respository");

        employeeRepository.deleteById(emp_id);

        return true;
    }
}
