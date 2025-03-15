package com.jmjbrothers.first_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmjbrothers.first_spring.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
