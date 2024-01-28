package com.hexaware.weekendpractice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address1To1")
public class AddressOneToOne {
	@Id
	private int addressId;
	private String city;
	@OneToOne(mappedBy="address")
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="Emp_id")
	//@Column not allowed for OneToOne mapping
	private EmployeeOneToOne emp;

	public AddressOneToOne() {
		super();
	}

	public AddressOneToOne(int addressId, String city) {
		super();
		this.addressId = addressId;
		this.city = city;
	}

	public AddressOneToOne(int address_id, String city, EmployeeOneToOne emp) {
		super();
		this.addressId = address_id;
		this.city = city;
		this.emp = emp;
	}

	public EmployeeOneToOne getEmp() {
		return emp;
	}

	public void setEmp(EmployeeOneToOne emp) {
		this.emp = emp;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "AddressOneToOne [addressId=" + addressId + ", city=" + city+ "]";
	}
	
}
