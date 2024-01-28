package com.hexaware.weekendpractice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Emp1To1")
public class EmployeeOneToOne {
	@Id
	private int eid;
	
	@Column(name="empname")
	private String ename;
	
	private double salary;
	@OneToOne(cascade=CascadeType.ALL)
// @Column is not allowed on OneToOne mapping
	@JoinColumn(name="address_id") // This is optional. We just used to give the address column a name.
	private AddressOneToOne address;
	public EmployeeOneToOne() {
		super();
	}
	public EmployeeOneToOne(int eid, String ename, double salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
	}
	
	public EmployeeOneToOne(int eid, String ename, double salary, AddressOneToOne address) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.address = address;
	}
	
	public AddressOneToOne getAddress() {
		return address;
	}
	public void setAddress(AddressOneToOne address) {
		this.address = address;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + "]";
	}
	
	
}
