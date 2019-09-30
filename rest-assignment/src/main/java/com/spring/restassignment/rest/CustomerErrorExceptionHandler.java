package com.spring.restassignment.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.restassignment.exception.CustomerNotFoundException;

@ControllerAdvice
public class CustomerErrorExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handlerException(CustomerNotFoundException exception){
		
		CustomerErrorResponse errorResponse = new CustomerErrorResponse(
														HttpStatus.NOT_FOUND.value(),
														exception.getMessage(),
														System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handlerException(Exception exception){
		
		CustomerErrorResponse errorResponse = new CustomerErrorResponse(
															HttpStatus.BAD_REQUEST.value(),
															exception.getMessage(),
															System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}

