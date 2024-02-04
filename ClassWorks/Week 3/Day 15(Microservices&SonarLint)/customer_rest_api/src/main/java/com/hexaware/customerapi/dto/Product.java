package com.hexaware.customerapi.dto;

public class Product { //POJO

	private int pid;
	private String pname;
	private double price;
	
	public Product() {
		super();
	}
	public Product(int pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
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
