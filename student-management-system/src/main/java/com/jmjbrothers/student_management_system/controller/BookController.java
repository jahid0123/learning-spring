package com.jmjbrothers.student_management_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmjbrothers.student_management_system.dto.BookDTO;
import com.jmjbrothers.student_management_system.model.Book;
import com.jmjbrothers.student_management_system.service.BookService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/books")
@Tag(name = "Book Controller", description = "Api for Book Management")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody BookDTO bookDTO) {
		Book saved = bookService.saveBook(bookDTO);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Book>> getAllBook() {
		List<Book> allBooks = bookService.getAllBook();
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updaBook(@PathVariable Integer id, @RequestBody Book book) {
		Book updateBook = bookService.updateBook(id, book);
		return new ResponseEntity<>(updateBook, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getABookById(@PathVariable Integer id) {
		Book getBookById = bookService.getABookById(id);
		return new ResponseEntity<>(getBookById, HttpStatus.OK);
	}

}
