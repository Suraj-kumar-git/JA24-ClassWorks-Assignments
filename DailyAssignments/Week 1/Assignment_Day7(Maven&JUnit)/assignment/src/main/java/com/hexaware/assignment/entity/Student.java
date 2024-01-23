package com.hexaware.assignment.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private int sid;
	private String sName;
	@Autowired
	Address address;
	
	public Student() {}

	public Student(int sid, String sName, Address address) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.address = address;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", address=" + address + "]";
	}
	
	
	
	
}
