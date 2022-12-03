package com.example.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.entity.Employee;

@Component
public interface EmployeeService {

	Employee postEmployee(Employee s);

	Employee getEmployee(int id);

	List<Employee> getAllEmployees();

	Employee updateEmployee(Employee params, int id);

	String deleteEmployee(int id);

}
