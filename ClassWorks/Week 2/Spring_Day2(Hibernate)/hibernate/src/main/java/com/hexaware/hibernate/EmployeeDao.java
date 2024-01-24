package com.hexaware.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hexaware.hibernate.entity.Employee;

public class EmployeeDao {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	public List<Employee> getAllEmployees(){
		Query query=session.createNamedQuery("getAllEmployees");
		List<Employee> allEmployees = query.getResultList();
		return allEmployees;
	}
	
	public List<Employee> getAllEmployeeByName(String name){
		Query query=session.createNamedQuery("getAllEmployeeByName");
		query.setParameter("name",name);
		Employee emp = (Employee)query.getSingleResult();
		List<Employee> allEmployees = query.getResultList();
		return allEmployees;
	}
}
