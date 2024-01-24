package com.hexaware.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hexaware.hibernate.entity.Employee;

public class HibernateSelect {

	public static void main(String[] args) {
		SessionFactory sessionFaactory = HibernateUtil.getSessionFactory();
		Session session = sessionFaactory.openSession();

//		String selectQuery="select e.eid,e.ename,e.salary from Employee e";

//		String selectQuery ="select e from Employee e where e.salary > ?1"; //Query with positional parameter
//		Query<Employee> query = session.createQuery(selectQuery);
//		query.setParameter(1, 45000.0);
//		List<Employee> employees= query.getResultList();
//		employees.stream().forEach(System.out::println);
		
//		String selectQuery ="select e from Employee e";
//		Query<Employee> query = session.createQuery(selectQuery);
//		List<Employee> employees= query.getResultList();
//		employees.stream().forEach(System.out::println);
		
//		String selectQuery2 = "select e from Employee e where e.ename like '%i%'";
		String selectQuery2 = "select e from Employee e where e.eid = :empid"; // This is Query with Named parameter
		Query<Employee> query2 = session.createQuery(selectQuery2);
		query2.setParameter("empid", 102);
		System.out.println(query2.getResultList());
	}

}
