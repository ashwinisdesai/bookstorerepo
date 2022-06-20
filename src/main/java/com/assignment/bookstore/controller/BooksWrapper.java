package com.assignment.bookstore.controller;

import java.util.List;

import com.assignment.bookstore.entity.Book;

public class BooksWrapper {

	private List<Book> booksInCart;
	
	BooksWrapper(){
		
	}

	/**
	 * @return the booksInCart
	 */
	public List<Book> getBooksInCart() {
		return booksInCart;
	}

	/**
	 * @param booksInCart the booksInCart to set
	 */
	public void setBooksInCart(List<Book> booksInCart) {
		this.booksInCart = booksInCart;
	}
	
}
