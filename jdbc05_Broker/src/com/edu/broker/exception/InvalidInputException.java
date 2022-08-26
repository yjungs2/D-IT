package com.edu.broker.exception;

public class InvalidInputException extends Exception {
	
	public InvalidInputException () {
		this("InvalidInputException");
	}
	
	public InvalidInputException (String message ) {
		super(message);
	}

}
