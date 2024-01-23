package com.hexaware.assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hexaware.assignment.entity.Address;
import com.hexaware.assignment.entity.Student;

/**
 * Author: Suraj Kumar
 *
 */
@Configuration
@ComponentScan("com.hexaware.assignment.entity")
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        Student std = context.getBean(Student.class);
        std.setSid(101);
        std.setsName("Suraj");
        std.setAddress(new Address());
        System.out.println(std);
    }
}
