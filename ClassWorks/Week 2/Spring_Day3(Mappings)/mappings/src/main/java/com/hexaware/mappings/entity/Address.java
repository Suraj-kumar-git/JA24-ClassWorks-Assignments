package com.hexaware.mappings.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	private int addressId;
	private String city;
	@OneToOne(mappedBy="address",cascade = CascadeType.ALL)
	private Student student;
	public Address() {
		super();
	}

	public Address(int addressId, String city,Student student) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.student=student;
	}

	public Address(int addressId, String city) {
		super();
		this.addressId = addressId;
		this.city = city;
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
	
	public void setStudent(Student student) {
		this.student=student;
	}
	
	public Student getStudent() {
		return student;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + "]";
	}

}
