package com.hexaware.weekendpractice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Emp1ToMany")
//@NamedQueries({
//	@NamedQuery(name="getAllEmployee",query="select e from Employee e"),
//	@NamedQuery(name="getAllEmployeeByName",query="select e from Employee e where e.ename = :name")
//})
public class EmployeeOneToMany {
	
	@Id
	private int eid;
	
	@Column(name="empname")
	private String ename;
	
	private double salary;
	
	@ManyToOne
	private DepartmentOneToMany department;
	public EmployeeOneToMany() {
		super();
	}
	public EmployeeOneToMany(int eid, String ename, double salary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
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
