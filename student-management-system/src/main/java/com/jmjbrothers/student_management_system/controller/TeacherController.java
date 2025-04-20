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

import com.jmjbrothers.student_management_system.model.Teacher;
import com.jmjbrothers.student_management_system.service.TeacherService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/teachers")
@Tag(name = "Teacher Controller", description = "Api for Teacher Management")
public class TeacherController {

	private final TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@PostMapping
	public ResponseEntity<?> saveTeacher(@RequestBody Teacher teacher) {
		Teacher savedTeacher = teacherService.saveTeacher(teacher);
		return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Teacher getTeacher(@PathVariable Integer id) {
		return teacherService.getTeacher(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {
		teacherService.deleteTeacher(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public List<Teacher> getAllTeacher() {

		return teacherService.getAllTeacher();
	}

	@PutMapping("/{id}")
	public Teacher updaTeacher(@PathVariable Integer id, @RequestBody Teacher teacher) {

		return teacherService.updateTeacher(id, teacher);
	}

}
