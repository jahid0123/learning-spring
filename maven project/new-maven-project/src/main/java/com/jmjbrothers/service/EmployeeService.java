package com.jmjbrothers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmjbrothers.model.Employee;
import com.jmjbrothers.repository.EmployeeRepository;

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

	public List<Employee> getAllEmp() {
		List<Employee> allEmp = repository.findAll();

		return allEmp;
	}

	public void deleteById(int id) {
		repository.deleteById(id);

	}

	public Employee updateEmp(int id, Employee employee) {
		employee.setId(id);
		repository.update(employee);
		return getEmpById(id);
	}

	public List<Employee> getEmpByName(String name) {
		List<Employee> emp = repository.findByName(name);
		return emp;
	}

}
