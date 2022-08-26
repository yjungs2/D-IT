package com.edu.book.exception;

public class InvalidInputException extends Exception{
	public InvalidInputException() {
		this("InvalidInputException...");
	}
	
	public InvalidInputException(String message) {
		super(message); // System.out.println(e.getMessage());
	}
}