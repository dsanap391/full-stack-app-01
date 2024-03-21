package com.ds.springbootcrudoperation.service;

import java.util.List;

import com.ds.springbootcrudoperation.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

    List<Employee> fetchAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployeeById(Long id, Employee employee);

    String deleteEmployeeById(Long id);
}
