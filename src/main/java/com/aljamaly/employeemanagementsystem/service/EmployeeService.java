package com.aljamaly.employeemanagementsystem.service;

import com.aljamaly.employeemanagementsystem.exception.UserNotFoundException;
import com.aljamaly.employeemanagementsystem.model.Employee;
import com.aljamaly.employeemanagementsystem.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee (Employee employee){
        employee.setEmpCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee (Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployee (Long id){
        return employeeRepo.findEmployeeById(id).
                orElseThrow(()-> new UserNotFoundException("User by id "+id+" is not found!"));
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public void deleteEmployee (Long id){
        employeeRepo.deleteById(id);
    }
}
