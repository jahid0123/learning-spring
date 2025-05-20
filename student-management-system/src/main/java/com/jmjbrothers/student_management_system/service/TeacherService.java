package com.jmjbrothers.student_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jmjbrothers.student_management_system.model.Teacher;
import com.jmjbrothers.student_management_system.repository.TeacherRepository;

@Service
public class TeacherService {

	private final TeacherRepository teacherRepository;

	public TeacherService(TeacherRepository repository) {
		this.teacherRepository = repository;
	}

	public Teacher saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.save(teacher);
	}

	public Teacher getTeacher(Integer id) {
		// TODO Auto-generated method stub
		return teacherRepository.findById(id).orElse(null);
	}

	public void deleteTeacher(Integer id) {
		// TODO Auto-generated method stub
		teacherRepository.deleteById(id);

	}

	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}

	public Teacher updateTeacher(Integer id, Teacher teacher) {

		Teacher teacherById = teacherRepository.findById(id).orElse(null);

		if (teacherById != null) {

			if (teacher.getName() != null) {
				teacherById.setName(teacher.getName());
			}

			if (teacher.getEmail() != null) {
				teacherById.setEmail(teacher.getEmail());
			}

			if (teacher.getPhone() != null) {
				teacherById.setPhone(teacher.getPhone());
			}

			if (teacher.getAddress() != null) {
				teacherById.setAddress(teacher.getAddress());
			}

			if (teacher.getGender() != null) {
				teacherById.setGender(teacher.getGender());
			}

			if (teacher.getJoiningDate() != null) {
				teacherById.setJoiningDate(teacher.getJoiningDate());
			}

			if (teacher.getSalary() != null) {
				teacherById.setSalary(teacher.getSalary());
			}

			if (teacher.getIsMarried() != null) {
				teacherById.setIsMarried(teacher.getIsMarried());
			}

			return teacherRepository.save(teacherById);
		} else {
			return null;
		}

	}

}
