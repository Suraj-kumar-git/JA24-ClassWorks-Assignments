package com.hexaware.springrestjpa.service;

import java.util.List;

import com.hexaware.springrestjpa.entity.Customer;

public interface ICustomerService {
	Customer addCustomer(Customer cust);
	List<Customer> getAllCustomer();
	Customer updateCustomer(Customer cust);
	String deleteCustomerById(Long id);
	List<Customer> findCustomerByUsername(String username);
	String deleteCustomerByUsername(String username);
	Customer findById(long id);
}
