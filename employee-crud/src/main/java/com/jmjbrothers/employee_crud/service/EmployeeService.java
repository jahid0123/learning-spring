package com.jmjbrothers.employee_crud.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmjbrothers.employee_crud.model.Employee;
import com.jmjbrothers.employee_crud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public Employee saveEmployee(Employee employee) {
		int saveEmployee = repository.save(employee);
		return getEmpById(saveEmployee);
	}

	public Employee getEmpById(int id) {

		Optional<Employee> byIdOptional = repository.findById(id);
		// TODO Auto-generated method stub
		return byIdOptional.get();
	}

}
