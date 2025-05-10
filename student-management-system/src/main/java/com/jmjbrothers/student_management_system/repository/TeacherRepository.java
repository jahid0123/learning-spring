package com.jmjbrothers.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmjbrothers.student_management_system.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
