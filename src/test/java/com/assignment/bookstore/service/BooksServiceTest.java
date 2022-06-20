package com.assignment.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.bookstore.entity.Book;
import com.assignment.bookstore.exception.ResourceNotFoundException;
import com.assignment.bookstore.repository.BooksRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BooksServiceTest {
	@Autowired
	private BooksService booksSvc;
	
	@Mock
	private BooksRepository booksRepo;
	
	private static Book book;
	
	private static List<Book> booksList;
	
	private static long id = 5L;
	
	private static Book updatedBook;
	
	@Test
	public void testGetAllBooks() {
		booksList = booksSvc.getAllBooks();
		
		assertFalse(booksList.isEmpty());
	}
	
	@Test
	public void testGetBookByID() {
		book = booksSvc.getBookById(id);
		assertFalse(book==null);
		
		ResourceNotFoundException thrown = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			book = booksSvc.getBookById(8L);
		});
		
		assertEquals("Book with ID 8 was not found.",thrown.getMessage());
	}
	
	@Test
	public void testAddBook() {
		book = new Book("Test Book","This is to test the add functionality","Developer","FICTION",BigDecimal.valueOf(65.60),1234567891);
		
		Book newBook = booksSvc.addBook(book);
		
		assertNotNull(newBook);
	}
	
	@Test
	public void testUpdateBook() {
		book = new Book("Test Book","This is just a test","Developer","FICTION",BigDecimal.valueOf(65.70),1234567891);
		
		updatedBook = booksSvc.updateBook(book, 6L);
		
		assertNotNull(updatedBook);
		
		ResourceNotFoundException ex = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			updatedBook = booksSvc.updateBook(book, 10L);
		});
		
		assertEquals("Book with ID 10 was not found.", ex.getMessage());
	}
	
	@Test
	public void testDeleteBook() {
		book.setId(2L);
		
		booksSvc.deleteBook(book.getId());
		
		ResourceNotFoundException ex = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			book = booksSvc.getBookById(book.getId());
		});
		
		assertEquals("Book with ID 2 was not found.", ex.getMessage());
		
		
		ResourceNotFoundException ex1 = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			booksSvc.deleteBook(20L);
		});
		
		assertEquals("Book with ID 20 was not found.", ex1.getMessage());
	}

}
