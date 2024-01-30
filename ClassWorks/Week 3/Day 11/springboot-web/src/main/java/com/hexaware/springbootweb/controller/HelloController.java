package com.hexaware.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/webapp") //optional
public class HelloController {
	
	@RequestMapping("/hello") //mandatory
	@ResponseBody
	public String sayHello() {
		return "Hello Friends!";
	}
	
	@GetMapping("/show") //Both mapping is corrects
//	@RequestMapping(value="/show",method=RequestMethod.GET)
	@ResponseBody
	public String show() {
		return "<h1 style='color:red'>Welcome to my application</h1>";
	}
	
}
