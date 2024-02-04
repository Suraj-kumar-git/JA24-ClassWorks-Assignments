package com.hexaware.customerapi.dto;

public class CustomerProductVO {
	private CustomerDTO customerDTO;
	private Product product;
	public CustomerProductVO(CustomerDTO customerDTO, Product product) {
		super();
		this.customerDTO = customerDTO;
		this.product = product;
	}
	public CustomerProductVO() {
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}
	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
