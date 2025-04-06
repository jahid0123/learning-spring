package com.jmjbrothers.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmjbrothers.student_management_system.dao.ClassTeacherProjection;
import com.jmjbrothers.student_management_system.dto.StudentClassDTO;
import com.jmjbrothers.student_management_system.model.StudentClass;
import com.jmjbrothers.student_management_system.model.Teacher;
import com.jmjbrothers.student_management_system.repository.StudentClassRepository;

@Service
public class StudentClassService {

	private final StudentClassRepository classRepository;
	private final TeacherService teacherService;

	public StudentClassService(StudentClassRepository classRepository, TeacherService teacherService) {

		this.classRepository = classRepository;
		this.teacherService = teacherService;
	}

	public StudentClass saveStudentClass(StudentClassDTO studentClass) {
		Integer teacherId = studentClass.getClassTeacherId();
		Teacher teacher = teacherService.getTeacher(teacherId);

		if (teacher == null) {

			throw new IllegalArgumentException("Teacher not found");
		}
		StudentClass studentClass2 = new StudentClass();
		studentClass2.setName(studentClass.getName());
		studentClass2.setRoomNumber(studentClass.getRoomNumber());
		studentClass2.setClassTeacher(teacher);

		return classRepository.save(studentClass2);
	}

	public List<StudentClass> getAllStudentClasses() {
		// TODO Auto-generated method stub
		return classRepository.findAll();
	}

	public void deleteById(Integer id) {
		classRepository.deleteById(id);

	}

	public StudentClass updateById(Integer id, StudentClassDTO studentClassDto) {

		Optional<StudentClass> updateStudentClass = classRepository.findById(id);

		if (updateStudentClass.isPresent()) {

			StudentClass aClass = new StudentClass();

			if (studentClassDto.getName() != null) {
				aClass.setName(studentClassDto.getName());
			}

			if (studentClassDto.getRoomNumber() != null) {
				aClass.setRoomNumber(studentClassDto.getRoomNumber());
			}

			if (studentClassDto.getClassTeacherId() != null) {
				Integer teacherId = studentClassDto.getClassTeacherId();
				Teacher teacher = teacherService.getTeacher(teacherId);

				if (teacher == null) {
					throw new IllegalArgumentException("Teacher no found");
				}

				aClass.setClassTeacher(teacher);
			}

			return classRepository.save(aClass);
		} else {

			throw new IllegalArgumentException("Class not found");
		}
	}

	public StudentClass getStudentClass(Integer id) {
		// TODO Auto-generated method stub
		return classRepository.findById(id).orElse(null);
	}

	public List<ClassTeacherProjection> getAllClassTeachers() {
		// TODO Auto-generated method stub
		return classRepository.getAllClassTeachers();
	}

}
