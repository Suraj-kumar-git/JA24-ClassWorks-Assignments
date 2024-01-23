package com.hexaware.springcore.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("emp")
@Scope("prototype")
public class Employee{
	
	private int eid;
	@Autowired
	private String name;
	@Autowired
	private Address add;
	
	Employee(){
		
	}

	public Employee(int eid, String name, Address add) {
		super();
		this.eid = eid;
		this.name = name;
		this.add = add;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", add=" + add + "]";
	}
	
	

}
