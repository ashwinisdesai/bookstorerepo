package com.assignment.bookstore.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.assignment.bookstore.entity.Book;
import com.assignment.bookstore.exception.BookStoreException;

public class CartUtils{

	public static BigDecimal calculateTotalPrice(List<Book> booksInCart, String promoCode) {
		BigDecimal totalPrice = BigDecimal.ZERO;
		
		for(Book book : booksInCart) {
			double discRate = 0;
			
			if(promoCode!=null) {
				switch(book.getType()) {
					case "FICTION":
						discRate = 0.1;
						break;
					case "COMIC":
						discRate = 0;
						break;
					case "MYSTERY":
						discRate = 0.2;
						break;
					case "ROMANCE":
						discRate = 0.3;
						break;
					default:
						discRate = 0;
						break;
				}
			}
			try {
				totalPrice = totalPrice.add(book.getPrice().subtract(book.getPrice().multiply(BigDecimal.valueOf(discRate))));
			}
			catch(ArithmeticException ex) {
				throw new ArithmeticException("Error in calculating the discount rate");
			}
			
		}
		
		return totalPrice.setScale(2, RoundingMode.HALF_EVEN);
	}

}
