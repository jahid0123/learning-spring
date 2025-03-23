package com.jmjbrothers.student_management_system.controller;

import java.util.List;

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

@RestController
@RequestMapping(name = "/teachers")
public class TeacherController {

	private final TeacherService teacherService;

	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@PostMapping
	public Teacher saveTeacher(@RequestBody Teacher teacher) {

		return teacherService.saveTeacher(teacher);
	}

	@GetMapping("/{id}")
	public Teacher getTeacher(@PathVariable Integer id) {

		return teacherService.getTeacher(id);
	}

	@DeleteMapping("/{id}")
	public void deleteTeacher(@PathVariable Integer id) {
		teacherService.deleteTeacher(id);
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
