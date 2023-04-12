package com.restfullwebservices.example.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
