package com.hexaware.mappings.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department {
	
	@Id
	private int departmentId;
	private String departmentName;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="department") // This we are using for ManyToOne
//	@OneToMany(cascade=CascadeType.ALL) // This we are using while OneToMany
//	@JoinColumn(name="dno") // This we used for OneToMany only
	private Set<Employee> employeeSet = new HashSet<>();
	
	

	public Department() {
		super();
	}
	public Department(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public void addEmployee(Employee employee) {
		employee.setDepartment(this); // This we needed for ManyToOne
		Set<Employee> set = getEmployeeSet();
		set.add(employee);
//		this.employeeSet.add(employee); //This also we can do for the above two lines
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
	
}
