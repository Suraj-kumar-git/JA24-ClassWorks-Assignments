package com.hexaware.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.hibernate.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println(sessionFactory);
        Session session = sessionFactory.openSession();
        System.out.println(session);
        
        Transaction txn = session.beginTransaction();
        
//        Employee emp2 = new Employee(103,"Mrs. King Kong",5000);
//        Employee emp3 = new Employee(102,"Mr. King Kong",57000);
//        Employee emp4 = new Employee(104,"King",5007);
//        Employee emp5 = new Employee(105,"Kong",50060);
//        Employee emp1 = new Employee(101,"King Kong",50000);
//        Serializable ser = session.save(emp1); //Insert or Update
//        session.save(emp2); //Insert or Update
//        session.save(emp3); //Insert or Update
//        session.save(emp4); //Insert or Update
//        session.save(emp5); //Insert or Update
//        System.out.println(ser.toString());
        
//        Employee emp1 = new Employee(101,"King Khan",50000);
//        session.update(emp1); // It is also updating the existing record
        
//        Employee emp1=session.get(Employee.class,101);
//        System.out.println(emp1);
//        
//        emp1.setEname("Mr.King Khan");
//        emp1.setSalary(60000);
//        Serializable ser = session.save(emp1);
//        System.out.println("Updated RecordID: "+ser.toString());
//        
//        Employee emp2=session.get(Employee.class,101);
//        System.out.println("updated record: "+emp2);
//        
//        session.delete(emp2);
        
//        Employee e = new Employee(105,"Kong",56000);
//        session.saveOrUpdate(e);
//        session.persist(e); //Insert or update
        
        
        txn.commit();
    }
}
