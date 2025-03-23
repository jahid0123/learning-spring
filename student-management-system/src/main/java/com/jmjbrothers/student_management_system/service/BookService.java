package com.jmjbrothers.student_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jmjbrothers.student_management_system.model.Book;
import com.jmjbrothers.student_management_system.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	public Book updateBook(Integer id, Book book) {

		Book bookById = bookRepository.findById(id).orElse(null);

		if (bookById != null) {

			if (book.getName() != null) {
				bookById.setName(book.getName());
			}

			if (book.getAuthor() != null) {
				bookById.setAuthor(book.getAuthor());
			}

			if (book.getPublisher() != null) {
				bookById.setPublisher(book.getPublisher());
			}

			return bookRepository.save(bookById);
		} else {
			return null;
		}

	}

	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteBook(Integer id) {
		// TODO Auto-generated method stub

	}

}
