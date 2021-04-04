package com.aljamaly.employeemanagementsystem;

import com.aljamaly.employeemanagementsystem.model.Employee;
import com.aljamaly.employeemanagementsystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List <Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping ("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable ("id") Long id){
        Employee employee = employeeService.findEmployee(id);
        return new ResponseEntity <> (employee, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee),
                                    HttpStatus.CREATED);
    }

    @PutMapping ("/update")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(employee),
                                    HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteEmployee (@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
