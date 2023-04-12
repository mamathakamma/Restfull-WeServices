package com.restfullwebservices.example.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime timstamp;
	private String message;
	private String details;
	
	public LocalDateTime getTimstamp() {
		return timstamp;
	}
	public void setTimstamp(LocalDateTime timstamp) {
		this.timstamp = timstamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ErrorDetails(LocalDateTime timstamp, String message, String details) {
		super();
		this.timstamp = timstamp;
		this.message = message;
		this.details = details;
	}
	
	
}
