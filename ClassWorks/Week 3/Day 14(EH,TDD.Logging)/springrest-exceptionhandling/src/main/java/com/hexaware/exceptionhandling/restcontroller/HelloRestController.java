package com.hexaware.exceptionhandling.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloRestController {
	
	@GetMapping("/div/{num1}/{num2}")
	public String divideNumber(@PathVariable int num1, @PathVariable int num2) {
		int result= num1/num2;
		return "result: "+result;
	}
	
//	@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED,reason="Sorry, you can't divide any number 'by zero'")
//	@ExceptionHandler({ArithmeticException.class})
//	public void exceptionHandler() {
//		System.out.println("Exception Handled...");
//	}
	
//	// @ResponseStatus(value=HttpStatus.EXPECTATION_FAILED,reason="Sorry, you can't divide any number 'by zero'")
//	@ExceptionHandler({ArithmeticException.class})
//	public ResponseEntity<String> exceptionHandler() {
//		
//		System.out.println("Exception Handled...");
//		
//		return new ResponseEntity<String>("Sorry, you can't divide any number 'by zero'",HttpStatus.BAD_REQUEST);
//	}
}
