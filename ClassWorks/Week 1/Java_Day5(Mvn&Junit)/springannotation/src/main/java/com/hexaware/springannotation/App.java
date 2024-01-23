package com.hexaware.springannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hexaware.springannotation.beans.Employee;

@Configuration
@ComponentScan(basePackages="com.hexaware.springannotation.beans.*")
public class App 
{
    public static void main( String[] args ){
    	ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    	Employee emp= context.getBean(Employee.class);
    	emp.setEid(1);
    	emp.setEname("Suraj");
    	System.out.println(emp);
    	
    }
}
