package com.hexaware.springrestdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-api")
public class HttpRestController {
	
	//	@RequestMapping(value="/get", method=RequestMethod.GET)
	@GetMapping("/get")
	public String getData() {
		
		return "get Method Executed";
	}

	@PostMapping("/add")
	public String postDate() {
		
		return "Data Added";
	}
	
	@PutMapping("/update")
	public String updateData() {
		
		return "Data Updated";
	}

	@DeleteMapping("/delete")
	public String get() {
		
		return "Data Deleted";
	}
}
