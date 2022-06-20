package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.assignment.bookstore.BookStoreApplication;
import com.assignment.bookstore.controller.BooksWrapper;
import com.assignment.bookstore.entity.Book;
import com.assignment.bookstore.service.CartService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BookStoreApplication.class)
public class CartControllerTest {
	@Autowired
	private CartService cartSvc = new CartService();
	
	private BooksWrapper booksWrapper = Mockito.mock(BooksWrapper.class);
	
	@Test
	public void testGetTotalPrice() throws Exception{
		Book book1 = new Book("Book1", "This is book1", "AD1", "COMIC", BigDecimal.valueOf(25), 1234567891L);
		Book book2 = new Book("Book2", "This is book2", "AD2", "MYSTERY", BigDecimal.valueOf(30.25), 1234567892L);
		
		List<Book> orderList = new ArrayList<>();
		orderList.add(book1);
		orderList.add(book2);
		
		when(booksWrapper.getBooksInCart()).thenReturn(orderList);
		
		BigDecimal totalPrice = cartSvc.checkout(booksWrapper.getBooksInCart(), "DISC");
		
		assertEquals(totalPrice,new BigDecimal("49.20"));
		
	}
}
