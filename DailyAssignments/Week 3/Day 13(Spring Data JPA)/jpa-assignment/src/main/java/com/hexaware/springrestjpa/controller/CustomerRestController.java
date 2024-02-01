package com.hexaware.springrestjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springrestjpa.entity.Customer;
import com.hexaware.springrestjpa.service.ICustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	@Autowired
	ICustomerService service;

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody @Valid Customer cust) {
		return service.addCustomer(cust);
	}

	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody @Valid Customer cust) {
		return service.updateCustomer(cust);
	}

	@GetMapping("/getAll")
	public List<Customer> getAll() {
		return service.getAllCustomer();
	}

	@DeleteMapping("delete/{eid}")
	public String deleteCustomer(@PathVariable long eid) {
		return service.deleteCustomerById(eid);
	}
	
	@GetMapping("/findById/{username}")
	public List<Customer> findById(@PathVariable String username) {
		return service.findCustomerByUsername(username);
	}
	
	@DeleteMapping("/deleteByUsername{username}")
	public String deleteByUsername(@PathVariable String username) {
		return service.deleteCustomerByUsername(username);
	}
}
