package com.hexaware.springrestjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springrestjpa.entity.Customer;
import com.hexaware.springrestjpa.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	CustomerRepository repo;
	@Override
	public Customer addCustomer(Customer cust) {
		return repo.save(cust);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return repo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer cust) {
//		return repo.updateCutomer(cust.getUserFirstName(),cust.getUserLastName(), cust.getCustomerId());
		return repo.save(cust);
	}

	@Override
	public String deleteCustomerById(Long id) {
		repo.deleteById(id);
		return "1 record deleted";
		
	}

	@Override
	public List<Customer> findCustomerByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public String deleteCustomerByUsername(String username) {
		int count=repo.deleteCustomerByUsername(username);
		return count+" record deleted...";
	}

}
