package com.hexaware.weekendpractice.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept1Tox")
@NamedQueries({
	@NamedQuery(name="selectAllDepartments",query="select d from DepartmentOneToMany d"),
	@NamedQuery(name="updateDepartmentById",query="update DepartmentOneToMany d set d.departmentName= ?1 where d.departmentId=?2"),
})
public class DepartmentOneToMany {
	@Id
	private int departmentId;
	private String departmentName;
	
	@OneToMany(cascade=CascadeType.ALL) // This we are using while OneToMany
	@JoinColumn(name="dno") // This we used for OneToMany only
	private Set<EmployeeOneToMany> employeeSet = new HashSet<>();

	public DepartmentOneToMany() {
		super();
	}
	public DepartmentOneToMany(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public void addEmployee(EmployeeOneToMany employee) {
		Set<EmployeeOneToMany> set = getEmployeeSet();
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
	public Set<EmployeeOneToMany> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<EmployeeOneToMany> employeeSet) {
		this.employeeSet = employeeSet;
	}
	@Override
	public String toString() {
		return "DepartmentOneToMany [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", employeeSet=" + employeeSet + "]";
	}
	
	
}
