package com.deepak.Employee_Service.repository;

import com.deepak.Employee_Service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmployeeName(String employeeName);
}
