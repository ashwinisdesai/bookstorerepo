package com.assignment.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.bookstore.entity.Book;
import com.assignment.bookstore.exception.ResourceNotFoundException;
import com.assignment.bookstore.repository.BooksRepository;

@Service
public class BooksService {
	
	@Autowired
	private BooksRepository booksRepo;

	public List<Book> getAllBooks() {
		List<Book> booksList = new ArrayList<>();
		
		booksList = booksRepo.findAll();
		
		return booksList;
	}

	public Book getBookById(Long id) {
		return booksRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with ID "+id+" was not found."));
	}

	public Book addBook(Book book) {
		return booksRepo.save(book);
	}

	public Book updateBook(Book updatedBook, Long id){
		Book book = booksRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with ID "+id+" was not found."));
		
		book.setName(updatedBook.getName());
		book.setDescription(updatedBook.getDescription());
		book.setAuthor(updatedBook.getAuthor());
		book.setPrice(updatedBook.getPrice()); book.setType(updatedBook.getType());
		book.setIsbn(updatedBook.getIsbn());
		
		return booksRepo.save(book);
	}

	public void deleteBook(Long id) {
		Book book = booksRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book with ID "+id+" was not found."));
				
		booksRepo.delete(book);
	}

}
