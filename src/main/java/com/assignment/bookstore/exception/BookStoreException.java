package com.assignment.bookstore.exception;

import java.util.Date;

public class BookStoreException {
	
	private String errorMsg;
	
	private String errorDetails;
	
	private Date errorTime;
	
	
	public BookStoreException(String errorMsg, String errorDetails, Date errorTime) {
		super();
		this.errorMsg = errorMsg;
		this.errorDetails = errorDetails;
		this.errorTime = errorTime;
	}


	public String getErrorMsg() {
		return errorMsg;
	}

	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
	public String getErrorDetails() {
		return errorDetails;
	}

	
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	
	public Date getErrorTime() {
		return errorTime;
	}

	
	public void setErrorTime(Date errorTime) {
		this.errorTime = errorTime;
	}

	
}
