package com.hexaware.restapi.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.restapi.dto.ProductDTO;
import com.hexaware.restapi.entity.Product;
import com.hexaware.restapi.exception.ProductNotFoundException;
import com.hexaware.restapi.service.IProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

	Logger logger = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	IProductService service;

	@PostMapping("/add")
	public Product addProduct(@RequestBody ProductDTO productDTO) {

		return service.addProduct(productDTO);
	}

	@GetMapping("/get/{pid}")
	public ProductDTO getById(@PathVariable @Valid @Min(1) int pid) throws ProductNotFoundException {

		ProductDTO productDTO = service.getById(pid);

		if (productDTO.getPid() == 0) {

			throw new ProductNotFoundException(HttpStatus.BAD_REQUEST, "Product Not Found for Pid : " + pid);
		}

		return productDTO;
	}

	@GetMapping("/getall")
	public List<Product> getAllProducts() {

		logger.debug("I am debug");
		logger.info("I am info");
		logger.warn("I am warning");

		logger.error("I am error");

		return service.getAllProducts();
	}

	@DeleteMapping("/delete/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		return service.deleteProduct(pid);
	}

	@PutMapping("/update")
	public String updateProduct(@RequestBody ProductDTO productDto) {
		return service.updateProduct(productDto);
	}

}
