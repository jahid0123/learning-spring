package com.jmjbrothers.student_management_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmjbrothers.student_management_system.dto.StudentDTO;
import com.jmjbrothers.student_management_system.model.Student;
import com.jmjbrothers.student_management_system.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/student")
@Tag(name = "Student Controller", description = "Api for Student Management")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService service) {
		this.studentService = service;
	}

	@PostMapping
	public ResponseEntity<Student> saveStudent(StudentDTO studentDTO) {
		Student saved = studentService.saveStudent(studentDTO);

		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id) {
		Student student = studentService.getStudent(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> allStudent = studentService.getAllStudent();
		return new ResponseEntity<>(allStudent, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO) {
		Student updateStudent = studentService.updateStudent(id, studentDTO);
		return new ResponseEntity<>(updateStudent, HttpStatus.OK);

	}
}
