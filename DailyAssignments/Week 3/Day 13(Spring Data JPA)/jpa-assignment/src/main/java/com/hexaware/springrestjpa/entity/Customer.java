package com.hexaware.springrestjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="jpa-cust")
public class Customer {
	@Id
	private Long customerId;
	
	private String userFirstName;
	private String userLastName;
	@NotEmpty
	private String username;
	@NotBlank
	@Size(min=3,max=8)
	private String password;
	

	public Customer() {
		super();
	}


	public Customer(Long customerId, String userFirstName, String userLastName, String username, String password) {
		super();
		this.customerId = customerId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.username = username;
		this.password = password;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getUserFirstName() {
		return userFirstName;
	}


	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}


	public String getUserLastName() {
		return userLastName;
	}


	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", userFirstName=" + userFirstName + ", userLastName="
				+ userLastName + ", username=" + username + ", password=" + password + "]";
	}

	
	
}
