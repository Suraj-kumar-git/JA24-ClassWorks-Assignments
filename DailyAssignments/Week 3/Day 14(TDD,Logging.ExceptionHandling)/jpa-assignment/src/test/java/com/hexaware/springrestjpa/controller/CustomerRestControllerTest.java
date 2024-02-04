package com.hexaware.springrestjpa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.springrestjpa.entity.Customer;

@SpringBootTest
class CustomerRestControllerTest {

	@Autowired
	RestTemplate restTemplate;

	Logger logger = LoggerFactory.getLogger(CustomerRestControllerTest.class);

	@Test
	void testAddCustomer() {
		Customer newCust = new Customer(5L, "Suraj", "Kumar", "Suraj@Kumar-test", "Suraj123");
		logger.info("Customer object created in Rest Controller");
		logger.info("Customer object is being sent to RestTemplate");

		ResponseEntity<Customer> response = restTemplate.postForEntity("http://localhost:8080/api/customer/add",
				newCust, Customer.class);
		Customer savedCust = response.getBody();
		logger.info("Saved Customer caught in Rest Controller...");
		assertEquals(newCust.getUsername(), savedCust.getUsername());
	}

	@Test
	void testUpdateCustomer() {
		Customer customerToUpdate = new Customer(2L, "Aanchal", "Kumari", "Aanchal@Kumari", "Aanchal123");
		restTemplate.put("http://localhost:8080/api/customer/update", customerToUpdate);
		Long cid = customerToUpdate.getCustomerId();
		ResponseEntity<Customer> response = restTemplate
				.getForEntity("http://localhost:8080/api/customer/findById/" + cid, Customer.class);
		Customer updatedCustomer = response.getBody();
		assertEquals(customerToUpdate.getUsername(), updatedCustomer.getUsername());
	}

	@Test
	void testGetAll() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/api/customer/getAll",
				List.class);
		List<Customer> customers = response.getBody();
//		List<Customer> response = restTemplate.getForObject("http://localhost:8080/api/customer/getAll", List.class);
//		for(Customer c:response) {
//			logger.info(c+"\n");
//		}
		assertTrue(customers.size() > 0);
	}

	@Test
	void testDeleteCustomer() {
		int cid=107;
		restTemplate.delete("http://localhost:8080/api/customer/delete/"+cid);
		assertNull(null);
	}

	@Test
	void testFindByUsername() {
		String username = "Suraj@Kumar-test";
		ResponseEntity<Customer> response = restTemplate
				.getForEntity("http://localhost:8080/api/customer/findByUsername/" + username, Customer.class);
		Customer cust = response.getBody();
		assertEquals(2, cust.getCustomerId());
	}

	@Test
	void testDeleteByUsername() {
		String username="Suraj@Kumar-test";
		restTemplate.delete("http://localhost:8080/api/customer/delete/"+username);
		assertNull(null);
	}

}
