package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.reporistory.EmployeeRepository;


@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee postEmployee(Employee e) {

		return employeeRepository.save(e);
	}

	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	public Employee updateEmployee(Employee params, int id) {
		// TODO Auto-generated method stub
		Employee _employee = employeeRepository.findById(id).get();
		_employee.setName(params.getName());
		_employee.setEmail(params.getEmail());
		return employeeRepository.save(_employee);
	}

	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		return "the employee with id " + id + " has been deleted...";
	}
	
}
