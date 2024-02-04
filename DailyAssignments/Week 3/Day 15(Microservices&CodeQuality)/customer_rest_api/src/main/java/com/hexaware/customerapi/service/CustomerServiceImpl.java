package com.hexaware.customerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.customerapi.dto.CustomerDTO;
import com.hexaware.customerapi.dto.CustomerProductVO;
import com.hexaware.customerapi.dto.Product;
import com.hexaware.customerapi.entity.Customer;
import com.hexaware.customerapi.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CustomerRepository repo;
	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setProductId(customerDTO.getProductId());
		return repo.save(customer);
	}

	@Override
	public CustomerDTO getCustomerById(int customerId) {
		Customer customer = repo.findById(customerId).orElse(null);
		CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerId(),customer.getCustomerName(),customer.getDateOfBirth(),customer.getProductId());
		return customerDTO;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> allCustomers = repo.findAll();
		return allCustomers;
//		return repo.findAll();
	}

	@Override
	public CustomerProductVO getCustomerAndProductById(int customerId) {
		//Step 1		CustomerDTO customer = getCustomerById(customerId);
		
		//Step 2 call restAPI from product microservice getProductById();
		//Product = //http://localhost:8282/api/products/get/customerId
		CustomerDTO customerDto = getCustomerById(customerId);
		int pid=customerDto.getProductId();
		Product product=restTemplate.getForObject("http://localhost:8282/api/products/get/"+pid,Product.class);
		CustomerProductVO vo = new CustomerProductVO();
		vo.setCustomerDTO(customerDto);
		vo.setProduct(product);
		return vo;
		// OR
//		return new CustomerProductVO(customerDto,product);
	}

	@Override
	public String deleteCustomerAndProduct(int customerId) {
		CustomerDTO customerdto = getCustomerById(customerId);
		int productId=customerdto.getProductId();
		restTemplate.delete("http://localhost:8282/api/products/delete/"+productId);
		Customer customer = new Customer(customerdto.getCustomerId(),customerdto.getCustomerName(),customerdto.getDateOfBirth(),customerdto.getProductId());
		repo.delete(customer);
		return "Customer & its associated Product is deleted...";
	}

	@Override
	public String updateProductOfCustomer(int customerId, int productId) {
		repo.update(customerId,productId);
		return "Customer "+customerId+"'s product changed to "+productId;
	}

}
