package com.assignment.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.bookstore.entity.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>{

}
