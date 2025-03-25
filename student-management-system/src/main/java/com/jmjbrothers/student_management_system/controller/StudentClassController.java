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

import com.jmjbrothers.student_management_system.dto.StudentClassDTO;
import com.jmjbrothers.student_management_system.model.StudentClass;
import com.jmjbrothers.student_management_system.service.StudentClassService;

@RestController
@RequestMapping(value = "/studentclass")
public class StudentClassController {

	private final StudentClassService classService;

	public StudentClassController(StudentClassService classService) {
		this.classService = classService;
	}

	// insert Student class
	@PostMapping
	public ResponseEntity<?> saveStudentClass(@RequestBody StudentClassDTO studentClass) {
		StudentClass savedClass = classService.saveStudentClass(studentClass);
		return new ResponseEntity<>(savedClass, HttpStatus.CREATED);
	}

	// get student class by Id
	@GetMapping("/{id}")
	public StudentClass getStudentClass(@PathVariable Integer id) {
		StudentClass byIdClass = classService.getStudentClass(id);
		return byIdClass;
	}

	// Get all student classes
	@GetMapping
	public List<StudentClass> getAllStudentClasses() {
		return classService.getAllStudentClasses();
	}

	// Delete student class by id
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		classService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// Update Student class by Id
	@PutMapping("/{id}")
	public StudentClass updateById(@PathVariable Integer id, @RequestBody StudentClassDTO studentClass) {
		StudentClass updaClass = classService.updateById(id, studentClass);
		return updaClass;
	}

}
