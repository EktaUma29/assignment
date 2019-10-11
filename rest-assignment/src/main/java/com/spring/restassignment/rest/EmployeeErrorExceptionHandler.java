package com.spring.restassignment.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.restassignment.exception.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeErrorExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handlerException(EmployeeNotFoundException exception){
		
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(
														HttpStatus.NOT_FOUND.value(),
														exception.getMessage(),
														System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handlerException(Exception exception){
		
		EmployeeErrorResponse errorResponse = new EmployeeErrorResponse(
															HttpStatus.BAD_REQUEST.value(),
															exception.getMessage(),
															System.currentTimeMillis());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}

