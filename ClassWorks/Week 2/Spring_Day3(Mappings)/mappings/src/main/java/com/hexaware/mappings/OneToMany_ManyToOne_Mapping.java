package com.hexaware.mappings;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.mappings.entity.Department;
import com.hexaware.mappings.entity.Employee;

/**
 * Hello world!
 *
 */
public class OneToMany_ManyToOne_Mapping {
    public static void main( String[] args ){
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	Session session = sessionFactory.openSession();
//    	System.out.println(session);

    	Employee emp1 = new Employee(1,"Suraj",50000.0);
    	Employee emp2 = new Employee(2,"Siddhi",5000.0);
    	Employee emp3 = new Employee(3,"Ayushi",52000.0);
    	Employee emp4 = new Employee(4,"Aanchal",51000.0);
    	
    	// These below methods to add emp to dept we dont use bcoz we again need to create a new HashSet. And we have already a HashSet present in the entity class.
//    	Set<Employee> employeeSet = new HashSet<>();
//    	employeeSet.add(emp1);
//    	employeeSet.add(emp2);
//    	employeeSet.add(emp3);
//    	employeeSet.add(emp4);
//    	Department dept = new Department(101,"FSD",employeeSet);
    	 // OR
//    	Department dept1 = new Department(101,"FSD");
//    	dept1.addEmployee(emp1);
//    	dept1.addEmployee(emp2);
//    	dept1.addEmployee(emp3);
//    	dept1.addEmployee(emp4);
    	
    	
    	Department dept1 = new Department(102,"SDE1");
    	dept1.addEmployee(emp1);
    	dept1.addEmployee(emp2);
    	dept1.addEmployee(emp3);
    	dept1.addEmployee(emp4);
    	
    	
    	
    	
    	Transaction txn = session.beginTransaction();
    	session.persist(dept1);
    	txn.commit();
    }
}
