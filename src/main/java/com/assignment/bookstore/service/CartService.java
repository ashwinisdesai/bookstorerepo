package com.assignment.bookstore.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.bookstore.entity.Book;
import com.assignment.bookstore.util.CartUtils;

@Service
public class CartService {

	public BigDecimal checkout(List<Book> booksInCart, String promoCode) {
		return CartUtils.calculateTotalPrice(booksInCart, promoCode);
	}

}
