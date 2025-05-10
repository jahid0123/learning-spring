package com.jmjbrothers.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmjbrothers.student_management_system.dto.BookDTO;
import com.jmjbrothers.student_management_system.model.Book;
import com.jmjbrothers.student_management_system.model.StudentClass;
import com.jmjbrothers.student_management_system.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	private final StudentClassService studentClassService;

	public BookService(BookRepository bookRepository, StudentClassService studentClassService) {
		this.bookRepository = bookRepository;
		this.studentClassService = studentClassService;
	}

	public Book saveBook(BookDTO bookDTO) {
		Integer clazzId = bookDTO.getClazzId();
		StudentClass clazz = studentClassService.getStudentClass(clazzId);

		Book book = new Book();
		book.setName(bookDTO.getName());
		book.setAuthor(bookDTO.getAuthor());
		book.setPublisher(bookDTO.getPublisher());

		if (clazz != null) {
			book.setClazz(clazz);
		}
		return bookRepository.save(book);
	}

	public Book updateBook(Integer id, Book book) {

		Optional<Book> bookById = bookRepository.findById(id);

		if (bookById.isPresent()) {
			Book aBook = new Book();

			if (book.getName() != null) {
				aBook.setName(book.getName());
			}

			if (book.getAuthor() != null) {
				aBook.setAuthor(book.getAuthor());
			}

			if (book.getPublisher() != null) {
				aBook.setPublisher(book.getPublisher());
			}

			if (book.getClazz() != null) {
				Integer classId = book.getClazz().getId();
				StudentClass clazz = studentClassService.getStudentClass(classId);
				if (clazz == null) {
					throw new IllegalArgumentException("Class not found");
				}
				aBook.setClazz(clazz);

			}
			return bookRepository.save(aBook);

		} else {
			throw new IllegalArgumentException("Book not found");
		}

	}

	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBook(Integer id) {
		// TODO Auto-generated method stub

	}

	public Book getABookById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
