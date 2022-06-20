package com.assignment.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.assignment.bookstore.entity.Book;
import com.assignment.bookstore.service.BooksService;

@RestController
@RequestMapping("/books/")
public class BooksController {
	
	@Autowired
	private BooksService booksSvc;
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		return booksSvc.getAllBooks();
	}
	
	@GetMapping("/getBook/{id}")
	public Book one(@PathVariable long id) {
		return booksSvc.getBookById(id);
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<?> addNewBook(@RequestBody Book book) {
		booksSvc.addBook(book);
		
		return new ResponseEntity<>("Book successfully created!", HttpStatus.OK);
	}
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<?> updateBook(@RequestBody Book updatedBook, @PathVariable long id) {
		booksSvc.updateBook(updatedBook, id);
		
		return new ResponseEntity<>("Book successfully updated!", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
	    booksSvc.deleteBook(id);
	    
	    return new ResponseEntity<>("Book successfully deleted!", HttpStatus.OK);
	}
	
}
