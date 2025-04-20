package com.jmjbrothers.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmjbrothers.student_management_system.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
