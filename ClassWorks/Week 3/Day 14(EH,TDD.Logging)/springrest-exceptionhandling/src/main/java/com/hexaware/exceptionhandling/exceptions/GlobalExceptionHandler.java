package com.hexaware.exceptionhandling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
//	@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE,reason="Sorry, Can't accept 'zero'")
//	@ExceptionHandler({ArithmeticException.class})
//	public void handleExp() {
//		
//	}
	
	@ExceptionHandler({ArithmeticException.class})
	public ResponseEntity<String> handleExp(ArithmeticException e) {
//		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<String>(e.toString(),HttpStatus.NOT_ACCEPTABLE);
	}
}
