package com.hexaware.springrestjpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.springrestjpa.entity.Customer;

@SpringBootTest
class CustomerServiceImplTest {
	
	@Autowired
	CustomerServiceImpl serviceTest;

	@Test
	void testAddCustomer1() {
		Customer newCustomer = new Customer(4L,"Suraj","Kumar","Suraj-Kumar1","Suraj123");
		serviceTest.addCustomer(newCustomer);
		Customer addedCustomer = serviceTest.findById(4);
		assertEquals(newCustomer.getCustomerId(),addedCustomer.getCustomerId());
	}
	@Test
	void testAddCustomer2() {
		Customer newCustomer = new Customer(2L,"Suraj","Kumar","Suraj-Kumar2","Suraj123");
		serviceTest.addCustomer(newCustomer);
		Customer addedCustomer = serviceTest.findById(2);
		assertEquals(newCustomer.getCustomerId(),addedCustomer.getCustomerId());
	}
	@Test
	void testAddCustomer3() {
		Customer newCustomer = new Customer(3L,"Suraj","Kumar","Suraj-Kumar3","Suraj123");
		serviceTest.addCustomer(newCustomer);
		Customer addedCustomer = serviceTest.findById(3);
		assertEquals(newCustomer.getCustomerId(),addedCustomer.getCustomerId());
	}

	@Test
	void testGetAllCustomer() {
		List<Customer> allCustomer = serviceTest.getAllCustomer();
		assertTrue(allCustomer.size()>=1);
	}

	@Test
	void testUpdateCustomer() {
		Customer customerToUpdate= new Customer(1L,"Suraj","Kumar","Suraj_kumar","Suraj123");
		Customer updatedCustomer = serviceTest.updateCustomer(customerToUpdate);
		assertEquals(customerToUpdate.getUsername(),updatedCustomer.getUsername());
	}

	@Test
	void testDeleteCustomerById() {
		long id =1;
		String returned=serviceTest.deleteCustomerById(id);
		assertEquals("1 record deleted",returned);
		
	}

	@Test
	void testFindCustomerByUsername() {
		String username="Suraj_kumar";
		List<Customer> searchedCustomer = serviceTest.findCustomerByUsername(username);
		assertNotNull(searchedCustomer);
		
	}

	@Test
	void testDeleteCustomerByUsername() {
		String username="Suraj_kumar";
		String returned=serviceTest.deleteCustomerByUsername(username);
		assertTrue(returned.contains("record deleted"));
	}

}
