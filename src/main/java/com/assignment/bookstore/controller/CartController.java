package com.assignment.bookstore.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.bookstore.service.CartService;

@RestController
@RequestMapping("/order/")
public class CartController {
	@Autowired
	private CartService cartSvc;
	
	@PostMapping("/getTotalPrice")
	public BigDecimal getTotalPrice(@RequestBody BooksWrapper booksWrapper, @RequestParam(required=false) String promoCode) {
		return cartSvc.checkout(booksWrapper.getBooksInCart(), promoCode);
	}
}
