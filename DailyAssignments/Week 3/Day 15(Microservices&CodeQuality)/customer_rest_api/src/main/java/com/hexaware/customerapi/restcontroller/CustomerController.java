package com.hexaware.customerapi.restcontroller;

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

import com.hexaware.customerapi.dto.CustomerDTO;
import com.hexaware.customerapi.dto.CustomerProductVO;
import com.hexaware.customerapi.entity.Customer;
import com.hexaware.customerapi.service.ICustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	ICustomerService service;
	
	@PostMapping(value="/add",consumes="application/xml")
	public Customer addCustomer(@RequestBody CustomerDTO customerDTO) {
		return service.addCustomer(customerDTO);
	}

	@GetMapping(value="/getById/{cid}",produces="application/xml")
	public CustomerDTO getCustomerById(@PathVariable (name="cid")int customerId) {
		return service.getCustomerById(customerId);
	}

	@GetMapping("/getAll")
	public List<Customer> getAllCustomer(){
		return service.getAllCustomer();
	}
	
	@GetMapping("/customer-product/{customerId}")
	public CustomerProductVO getCustomerAndProductById(@PathVariable int customerId) {
		return service.getCustomerAndProductById(customerId);
	}
	
	@DeleteMapping("/delete/Customer&Product/{customerId}")
	public String deleteCustomerAndproduct(@PathVariable int customerId) {
		return service.deleteCustomerAndProduct(customerId);
	}
	
	@PutMapping("/update/CustomersProduct/{customerId}/{pid}")
	public String updateProductOfCustomer(@PathVariable int customerId,@PathVariable int pid) {
		return service.updateProductOfCustomer(customerId,pid);
	}
}
