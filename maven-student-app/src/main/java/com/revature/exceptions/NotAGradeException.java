package com.revature.exceptions;

public class NotAGradeException extends RuntimeException {
	
	//alt + shift + s -> generate constructors from superclass
	
	public NotAGradeException(String message) {
		super(message);
		
	}
	
	// Below are all possible options, but are only her efor demo purposes

	public NotAGradeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotAGradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotAGradeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotAGradeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
