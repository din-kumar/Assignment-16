package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;





@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// add a student (no ResponseEntity)
	@PostMapping(value = "/employee")
	public Employee addController(@RequestBody Employee employee) {
		return employeeService.postEmployee(employee);
	}

	// get a student
	@GetMapping(value = "/employee/{id}")
	public Employee getController(@PathVariable int id) {
		return employeeService.getEmployee(id);
	}

	// get all students
	@GetMapping(value = "/employee")
	public List<Employee> getAllController() {
		return employeeService.getAllEmployees();
	}

	// update a student
	@PutMapping(value = "/employee/{id}")
	public Employee updateController(@PathVariable int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(employee, id);
	}

	// delete a student

	@DeleteMapping(value = "/employee/{id}")
	public String deleteController(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}

	// add a student (with ResponseEntity)
	@PostMapping("/employeeValid")
	public ResponseEntity<Employee> addValidEmployee(@Validated @RequestBody Employee e) {
		Employee savedEmployee = employeeService.postEmployee(e);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);

	}
	
}
