package com.hexaware.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.springcore.entities.Employee;
import com.hexaware.springcore.services.IService;
import com.hexaware.springcore.services.ServiceImpl;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		//Address address = context.getBean(Address.class);
			//	address.setCity("Hyderabad");

		Employee emp = context.getBean("emp", Employee.class);

		emp.setEid(101);
		emp.setName("king");
		//emp.setAddress(address);  // Setter method DI
		
		System.out.println(emp);
		
		Employee emp2 = context.getBean("emp", Employee.class);
		
		System.out.println(emp2.getAdd());
		
		
		IService service =	 context.getBean(ServiceImpl.class);
		
		
			service.getService();
			
			
			String name =		context.getBean(String.class);
		
			System.out.println(name);
		

	}
}
