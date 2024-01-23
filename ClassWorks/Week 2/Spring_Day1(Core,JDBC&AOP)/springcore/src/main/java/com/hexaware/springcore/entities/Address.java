package com.hexaware.springcore.entities;

import org.springframework.stereotype.Component;

@Component
public class Address {
	String vill;
	String city;
	String state;
	String country;
	public Address() {
		
	}
	public Address(String vill, String city, String state, String country) {
		super();
		this.vill = vill;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public String getVill() {
		return vill;
	}
	public void setVill(String vill) {
		this.vill = vill;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [vill=" + vill + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	
}
