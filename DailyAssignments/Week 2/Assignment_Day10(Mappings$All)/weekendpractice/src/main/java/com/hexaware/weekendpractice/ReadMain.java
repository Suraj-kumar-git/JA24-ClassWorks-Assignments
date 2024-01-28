package com.hexaware.weekendpractice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hexaware.weekendpractice.entity.AddressOneToOne;
import com.hexaware.weekendpractice.entity.DepartmentOneToMany;
import com.hexaware.weekendpractice.entity.EmployeeOneToMany;
import com.hexaware.weekendpractice.entity.EmployeeOneToOne;

public class ReadMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

//		String select1 = "Select e from EmployeeOneToOne e";
//		Query query1 = session.createQuery(select1);
//		List<EmployeeOneToOne> employees = query1.getResultList();
//		employees.stream().forEach(System.out::println);
//
//		String select2 = "select e from EmployeeOneToOne e where e.eid=?1";
//		Query query2 = session.createQuery(select2);
//		query2.setParameter(1, 3);
//		List<EmployeeOneToOne> employees2 = query2.getResultList();
//		employees2.stream().forEach(System.out::println);
//
//		String select3 = "select a from AddressOneToOne a where a.addressId=?1";
//		Query query3 = session.createQuery(select3);
//		query3.setParameter(1, 103);
//		List<AddressOneToOne> addresses = query3.getResultList();
//		addresses.stream().forEach(System.out::println);
		
		String select1 = "Select e from EmployeeOneToMany e";
		Query query1 = session.createQuery(select1);
		List<EmployeeOneToMany> employees = query1.getResultList();
		employees.stream().forEach(System.out::println);

		String select2 = "select e from EmployeeOneToMany e where e.eid=?1";
		Query query2 = session.createQuery(select2);
		query2.setParameter(1, 3);
		List<EmployeeOneToMany> employees2 = query2.getResultList();
		employees2.stream().forEach(System.out::println);

		Query query = session.createNamedQuery("selectAllDepartments", DepartmentOneToMany.class);
		List<DepartmentOneToMany> allDepartments = query.getResultList();
		allDepartments.stream().forEach(System.out::println);
		
		String select3 = "select a from DepartmentOneToMany a where a.departmentId=?1";
		Query query3 = session.createQuery(select3);
		query3.setParameter(1, 103);
		List<DepartmentOneToMany> departments = query3.getResultList();
		departments.stream().forEach(System.out::println);

		session.close();
	}
}
