package com.java.lms.exception;

@SuppressWarnings("serial")
public class CustomExeption extends Exception {

	public CustomExeption() {
		super();
	}

	public CustomExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomExeption(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomExeption(String message) {
		super(message);
	}

	public CustomExeption(Throwable cause) {
		super(cause);
	}
}
