package com.jmjbrothers.student_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmjbrothers.student_management_system.model.Book;
import com.jmjbrothers.student_management_system.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		// TODO: process POST request

		return bookService.saveBook(book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
	}

	@GetMapping
	public List<Book> getAllBook() {

		return bookService.getAllBook();
	}

	@PutMapping("/{id}")
	public Book updaBook(@PathVariable Integer id, @RequestBody Book book) {

		return bookService.updateBook(id, book);
	}

}
