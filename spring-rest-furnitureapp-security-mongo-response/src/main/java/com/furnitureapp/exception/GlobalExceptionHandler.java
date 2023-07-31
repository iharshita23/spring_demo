package com.furnitureapp.exception;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.furnitureapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Message not allowed";
		HttpStatus httpStatus = HttpStatus.valueOf(status.value());
		ApiErrors apiError = new ApiErrors(message, status, LocalDateTime.now(), error, status.value());
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Media type not supported";
		HttpStatus httpStatus = HttpStatus.valueOf(status.value());
		ApiErrors apiError = new ApiErrors(message, status, LocalDateTime.now(), error, status.value());
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Missing path variable";
		HttpStatus httpStatus = HttpStatus.valueOf(status.value());
		ApiErrors apiError = new ApiErrors(message, status, LocalDateTime.now(), error, status.value());
		return ResponseEntity.status(status).headers(headers).body(apiError);	
	}


	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Request parameter is missing";
		HttpStatus httpStatus = HttpStatus.valueOf(status.value());
		ApiErrors apiError = new ApiErrors(message, status, LocalDateTime.now(), error, status.value());
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		String message = ex.getMessage();
		String error = "Type mismatch";
		HttpStatus httpStatus = HttpStatus.valueOf(status.value());
		ApiErrors apiError = new ApiErrors(message, status, LocalDateTime.now(), error, status.value());
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}
	
	@ExceptionHandler(FurnitureNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFound(FurnitureNotFoundException ex){
		String message = ex.getMessage();
		String error = "Furniture for this search not found";
		HttpStatus httpStatus = HttpStatus.valueOf(HttpStatus.NOT_ACCEPTABLE.value());
		ApiErrors apiError = new ApiErrors(message, HttpStatus.NOT_ACCEPTABLE, LocalDateTime.now(), error, HttpStatus.NOT_ACCEPTABLE.value());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).header("error", "Furniture Not Found Exception").body(apiError);
	}

	
}
