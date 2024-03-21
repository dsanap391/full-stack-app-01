package com.ds.springbootcrudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ds.springbootcrudoperation.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
