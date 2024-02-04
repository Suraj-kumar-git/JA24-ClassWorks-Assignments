package com.hexaware.springrestjpa.service;

import java.util.List;

import com.hexaware.springrestjpa.dto.EmployeeDTO;
import com.hexaware.springrestjpa.entities.Employee;

public interface IEmployeeService {
	public Employee addEmployee(EmployeeDTO emp);

	public Employee updateEmployee(Employee emp);

	public List<Employee> getAll();

	public String deleteEmployee(long id);

	public Employee getEmployeeById(long id);
	
	public List<Employee> getByEname(String name);
	
	public List<Employee> findBySalaryGreaterThan(double salary);
	
	public List<Employee> findBySalaryLessThan(double salary);
	
	public List<Employee> getBySalarySorted();
	
	public List<Employee> getBySalaryRange(double min,double max);
	
	public int deleteByEname(String ename);
}
