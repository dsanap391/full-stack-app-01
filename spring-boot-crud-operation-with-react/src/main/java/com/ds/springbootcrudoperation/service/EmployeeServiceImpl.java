package com.ds.springbootcrudoperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ds.springbootcrudoperation.model.Employee;
import com.ds.springbootcrudoperation.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		System.out.println(employee);
		 return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		List<Employee> list = employeeRepository.findAll();
		return list;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp= employeeRepository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
	}

	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {
		Optional<Employee> updatedEmployee = employeeRepository.findById(id);
		if(updatedEmployee.isPresent()) {
			Employee newEmp = updatedEmployee.get();
			newEmp.setFirstName(employee.getFirstName());
			newEmp.setLastName(employee.getLastName());
			newEmp.setEmailId(employee.getEmailId());
			
			return employeeRepository.save(newEmp);
		}
		return null;
	}

	@Override
	public String deleteEmployeeById(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee deleted successfully";
		}
		return "no such employee in the database";
	}
}
