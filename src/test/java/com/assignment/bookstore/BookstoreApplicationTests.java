package com.assignment.bookstore;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assignment.bookstore.controller.BooksController;
import com.assignment.bookstore.controller.CartController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired
	private BooksController booksController;
	
	@Autowired
	private CartController cartController;
	

	@Test
	void contextLoads() {
		assertNotNull(booksController);
		
		assertNotNull(cartController);
	}

}
