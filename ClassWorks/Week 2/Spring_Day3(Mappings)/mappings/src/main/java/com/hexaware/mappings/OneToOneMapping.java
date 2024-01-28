package com.hexaware.mappings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.mappings.entity.Address;
import com.hexaware.mappings.entity.Student;

/**
 * Hello world!
 *
 */
public class OneToOneMapping {
    public static void main( String[] args ){
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    	Session session = sessionFactory.openSession();
//    	System.out.println(session);
    	//Uni-directional
//    	Address address = new Address(21,"Hyderabasd");
//    	Student student = new Student(101,"Raju",address);
    	
    	//Bi-directional
//    	Student student = new Student(106,"Raju");
//    	Address address = new Address(26,"Delhi",student); 
    	
    	//using Setters
    	Student student = new Student();
    	student.setStudentId(108);
    	student.setStudentName("Suraj");
    	Address address = new Address(28,"Muzaffarpur",student);  
    	
    	Transaction txn = session.beginTransaction();
    	session.persist(address);
    	txn.commit();
    }
}
