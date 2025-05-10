package com.jmjbrothers.first_spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmjbrothers.first_spring.model.Student;
import com.jmjbrothers.first_spring.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Value("${custom.env}")
	private String envString;
	private final StudentService service;

	public StudentController(StudentService service) {
		this.service = service;

	}

	@PostMapping
	public Student saveStudent(@RequestBody Student student) {

		Student saveStudent = service.saveStudent(student);
		// service.saveStudent(student);
		// List<Student> students = service.getStudents();
		return saveStudent;
	}

	@GetMapping
	public List<Student> getStudents() {

		return service.getStudents();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {

		Optional<Student> existingStudent = service.findStudentById(id);
		Student st = null;
		if (existingStudent.isPresent()) {
			st = existingStudent.get();

			if (st.getName() != student.getName())
				st.setName(student.getName());

			if (st.getAddress() != student.getAddress())
				st.setAddress(student.getAddress());

			if (st.getAge() != student.getAge())
				st.setAge(student.getAge());

			if (st.getClazz() != student.getClazz())
				st.setClazz(student.getClazz());

			if (st.getDob() != student.getDob())
				st.setDob(student.getDob());
		}

		return service.saveStudent(st);
	}

	@GetMapping("/hello")
	public String hello() {

		return "Hello Environment " + envString;
	}

}
