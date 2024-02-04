package com.hexaware.restapi.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {  // Product Entity class 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String pname;
	private double price;
	
	public Product(int pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	
	
	
	
	
	

}
