package com.jmjbrothers.student_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jmjbrothers.student_management_system.dao.ClassTeacher;
import com.jmjbrothers.student_management_system.dao.ClassTeacherProjection;
import com.jmjbrothers.student_management_system.model.StudentClass;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {

	@Query("Select sc.name AS className, sc.roomNumber AS Room, sc.classTeacher.name AS teacherName, sc.classTeacher.email AS TeacherEmail from StudentClass sc")
	List<ClassTeacherProjection> getAllClassTeachers();

	@Query("Select sc.name AS className, sc.roomNumber AS Room, sc.classTeacher.name AS teacherName, sc.classTeacher.email AS TeacherEmail from StudentClass sc")
	List<ClassTeacher> getAllClassTeachersDTO();

	@Query(value = " SELECT sc.NAME as className, sc.ROOM_NUMBER as roomNumber, ct.NAME as teacherName, ct.EMAIL as Email \r\n"
			+ "FROM T_Class sc\r\n" + "JOIN T_TEACHER ct\r\n" + "ON ct.ID = sc.CLASS_TEACHER", nativeQuery = true)
	List<ClassTeacherProjection> findAllActiveUsersNative();

}
