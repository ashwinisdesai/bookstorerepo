package com.assignment.bookstore.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class GlobalExceptionHandler{
	private static BookStoreException bookStoreException;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
		bookStoreException = new BookStoreException(exception.getMessage(), request.getDescription(false), new Date());
		
		return new ResponseEntity<>(bookStoreException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleGlobalException(RuntimeException exception, WebRequest request){
		bookStoreException = new BookStoreException(exception.getMessage(), request.getDescription(false), new Date());
		
		return new ResponseEntity<>(bookStoreException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({MissingServletRequestParameterException.class,InvalidFormatException.class})
	public ResponseEntity<?> handleMissingParamException(MissingServletRequestParameterException ex, WebRequest request){
		bookStoreException = new BookStoreException(ex.getMessage(), request.getDescription(false), new Date());
		
		return new ResponseEntity<>(bookStoreException, HttpStatus.BAD_REQUEST);
	}
}
