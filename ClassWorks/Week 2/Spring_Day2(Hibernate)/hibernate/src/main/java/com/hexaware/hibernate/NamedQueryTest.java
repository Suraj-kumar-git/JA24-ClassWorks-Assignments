package com.hexaware.hibernate;

import java.util.List;

import com.hexaware.hibernate.entity.Employee;

public class NamedQueryTest {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		System.out.println("Employees from named query: ");
//		List<Employee> list = dao.getAllEmployees();
//		list.stream().forEach(System.out::println);
		
		List<Employee> empList =dao.getAllEmployeeByName("King");
		empList.stream().forEach(System.out::println);
	}
	
}
