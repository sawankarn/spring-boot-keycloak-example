package com.javapuzzle.springbootkeycloakexample.repository;

import com.javapuzzle.springbootkeycloakexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
