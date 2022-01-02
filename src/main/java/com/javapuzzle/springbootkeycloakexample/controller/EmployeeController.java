package com.javapuzzle.springbootkeycloakexample.controller;

import com.javapuzzle.springbootkeycloakexample.model.Employee;
import com.javapuzzle.springbootkeycloakexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/admin/employee")
    @RolesAllowed("admin")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping("/user/employee")
    @RolesAllowed({"employee","admin"})
    public ResponseEntity<List<Employee>> getEmployee(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}
