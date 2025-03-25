package com.jmjbrothers.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmjbrothers.student_management_system.model.StudentClass;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {

}
