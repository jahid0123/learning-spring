package com.jmjbrothers.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmjbrothers.student_management_system.dto.StudentDTO;
import com.jmjbrothers.student_management_system.model.Student;
import com.jmjbrothers.student_management_system.model.StudentClass;
import com.jmjbrothers.student_management_system.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	private final StudentClassService studentClassService;
	// private final

	public StudentService(StudentRepository studentRepository, StudentClassService studentClassService) {
		this.studentRepository = studentRepository;
		this.studentClassService = studentClassService;
	}

	public Student saveStudent(StudentDTO studentDTO) {
		Integer clazzId = studentDTO.getClassId();
		StudentClass clazz = studentClassService.getStudentClass(clazzId);

		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		if (clazz != null) {
			student.setClazz(clazz);
		}
		student.setRoll(studentDTO.getRoll());
		student.setPhone(studentDTO.getPhone());
		student.setAddress(studentDTO.getAddress());
		student.setGender(studentDTO.getGender());
		student.setDob(studentDTO.getDob());

		return studentRepository.save(student);
	}

	public Student getStudent(Integer id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElse(null);
	}

	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);

	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	public Student updateStudent(Integer id, StudentDTO studentDTO) {
		Optional<Student> studentById = studentRepository.findById(id);

		if (studentById.isPresent()) {
			Student aStudent = new Student();
			if (studentDTO.getName() != null) {
				aStudent.setName(studentDTO.getName());
			}

			if (studentDTO.getEmail() != null) {
				aStudent.setEmail(studentDTO.getEmail());
			}

			if (studentDTO.getClassId() != null) {
				Integer classId = studentDTO.getClassId();
				StudentClass clazz = studentClassService.getStudentClass(classId);
				if (clazz == null) {
					throw new IllegalArgumentException("Class not found");
				}
				aStudent.setClazz(clazz);
			}
			if (studentDTO.getRoll() != null) {
				aStudent.setRoll(studentDTO.getRoll());
			}

			/*
			 * if (studentDTO.getBookIds() != null) {
			 * aStudent.setBook(studentDTO.getBookIds()); }
			 */

			if (studentDTO.getPhone() != null) {
				aStudent.setPhone(studentDTO.getPhone());
			}

			if (studentDTO.getAddress() != null) {
				aStudent.setAddress(studentDTO.getAddress());
			}

			if (studentDTO.getGender() != null) {
				aStudent.setGender(studentDTO.getGender());
			}

			if (studentDTO.getDob() != null) {
				aStudent.setDob(studentDTO.getDob());
			}

			return studentRepository.save(aStudent);
		} else {
			throw new IllegalArgumentException("Student no found");
		}
	}

}
