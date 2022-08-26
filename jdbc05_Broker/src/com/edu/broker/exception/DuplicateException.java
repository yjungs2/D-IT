package com.edu.broker.exception;

public class DuplicateException extends Exception {
	
	public DuplicateException () {
		this("DuplicateException");
	}
	
	public DuplicateException (String message ) {
		super(message);
	}

}
