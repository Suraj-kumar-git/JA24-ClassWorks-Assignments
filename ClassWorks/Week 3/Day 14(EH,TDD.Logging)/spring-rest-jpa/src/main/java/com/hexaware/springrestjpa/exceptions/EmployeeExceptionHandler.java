package com.hexaware.springrestjpa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	
//	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Employee Not Found in database...")
//	@ExceptionHandler({EmployeeNotFoundException.class})
//	public void handler() {
//		
//	}
	
	@ExceptionHandler({EmployeeNotFoundException.class})
	public ResponseEntity<String> handler() {
		return new ResponseEntity<String>("Sorry, Employee not found in database",HttpStatus.NOT_FOUND);
	}
}
