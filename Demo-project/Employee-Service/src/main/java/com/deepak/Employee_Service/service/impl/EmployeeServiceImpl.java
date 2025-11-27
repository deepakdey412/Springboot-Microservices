package com.deepak.Employee_Service.service.impl;

import com.deepak.Employee_Service.entity.Employee;
import com.deepak.Employee_Service.exception.EmployeeAlreadyExists;
import com.deepak.Employee_Service.exception.EmployeeNotFound;
import com.deepak.Employee_Service.repository.EmployeeRepository;
import com.deepak.Employee_Service.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        employeeRepository.findByEmployeeName(employee.getEmployeeName())
                .ifPresent(emp -> { throw new EmployeeAlreadyExists("Employee already exists"); });
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findUser(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee existingEmp = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found"));

        existingEmp.setEmployeeName(employee.getEmployeeName());
        existingEmp.setEmail(employee.getEmail());
        existingEmp.setPassword(employee.getPassword());

        return employeeRepository.save(existingEmp);
    }

    @Override
    public String delete(Long id) {
        Employee existingEmp = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFound("Employee not found"));

        employeeRepository.delete(existingEmp);
        return "User has been deleted";
    }
}
