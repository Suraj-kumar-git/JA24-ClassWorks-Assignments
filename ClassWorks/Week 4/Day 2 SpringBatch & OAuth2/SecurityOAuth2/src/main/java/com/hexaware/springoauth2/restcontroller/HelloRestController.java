package com.hexaware.springoauth2.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello, Suraj";
	}
	
	@GetMapping("/secure")
	public String isItSecure() {
		return "This is secured resource...after authorization using gitHub.";
	}
}
