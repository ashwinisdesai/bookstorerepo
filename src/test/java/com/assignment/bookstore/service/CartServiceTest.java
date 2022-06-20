package com.assignment.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.bookstore.entity.Book;
import com.assignment.bookstore.util.CartUtils;

@SpringBootTest
public class CartServiceTest {
	@Autowired
	private static CartService cartService = new CartService();
	
	private static List<Book> booksInCart = new ArrayList<>();
	
	private static BigDecimal totalPrice;
	
	@Test
	public void testCheckout() {
		Book book1 = new Book("ABC","This is ABC","AD1","MYSTERY",BigDecimal.valueOf(55.25),2345678928L);
		booksInCart.add(book1);
		
		Book book2 = new Book("DEF","This is DEF","AD2","ROMANCE",BigDecimal.valueOf(45),2345678926L);
		booksInCart.add(book2);
		
		Book book3 = new Book("GHI","This is GHI","AD3","COMIC",BigDecimal.valueOf(60),2345678927L);
		booksInCart.add(book3);
		
		Book book4 = new Book("JKL","This is JKL","AD4","FICTION",BigDecimal.valueOf(62.50),2345678924L);
		booksInCart.add(book4);
		
		Book book5 = new Book("MNO","This is MNO","AD5","UNKNOWN",BigDecimal.valueOf(75.55),2345678923L);
		booksInCart.add(book5);
		
		totalPrice = cartService.checkout(booksInCart, "DISC10");
		
		assertTrue(totalPrice!=null);
		
		totalPrice = cartService.checkout(booksInCart, null);
		
		assertTrue(totalPrice!=null);
		
		RuntimeException ex = Assertions.assertThrows(RuntimeException.class, () -> {
			Book book6 = new Book("PQR","This is PQR","AD6","MYSTERY",new BigDecimal("AA"),2345678922L);
			booksInCart.add(book6);
			
			totalPrice = cartService.checkout(booksInCart, "SUM5");
		});
	}
}
