package com.furnitureapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

public class ApiErrors {
	private String message;
	private HttpStatusCode status;
	private LocalDateTime timestamp;
	private String error;
	private int statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatusCode getStatus() {
		return status;
	}
	public void setStatus(HttpStatusCode status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public ApiErrors(String message, HttpStatusCode status, LocalDateTime timestamp, String error, int statusCode) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
		this.error = error;
		this.statusCode = statusCode;
	}
	public ApiErrors() {
		super();
		
	}
	@Override
	public String toString() {
		return "ApiErrors [message=" + message + ", status=" + status + ", timestamp=" + timestamp + ", error=" + error
				+ ", statusCode=" + statusCode + "]";
	}		
}
