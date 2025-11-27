package com.deepak.Employee_Service.service;

import com.deepak.Employee_Service.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee save(Employee employee);
    Employee findUser(Long id);
    List<Employee> findAll();
    Employee update(Long id , Employee employee);
    String delete(Long id);
}
