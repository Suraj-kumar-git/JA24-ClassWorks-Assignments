package com.hexaware.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.hexaware.springboot1.entity.Employee;
import com.hexaware.springboot1.service.EmployeeServiceImpl;
import com.hexaware.springboot1.service.IEmployeeService;

@SpringBootApplication
public class Springboot1Application {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(Springboot1Application.class, args);
		
		System.out.println("\n***************************\n");
		System.out.println(context);
		IEmployeeService service = context.getBean(EmployeeServiceImpl.class);
		Employee emp = context.getBean(Employee.class);
		emp.setEid(1);
		emp.setName("Suraj");
		
		System.out.println();
		service.showService();
		System.out.println(emp);
	}

}
