package com.jmjbrothers.first_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmjbrothers.first_spring.model.Student;
import com.jmjbrothers.first_spring.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository repository;

	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public Student saveStudent(Student student) {

		Student saved = repository.save(student);
		return saved;
	}

	public List<Student> getStudents() {

		return repository.findAll();
	}

	public void deleteById(int id) {

		repository.deleteById(id);

	}

	public Optional<Student> findStudentById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
