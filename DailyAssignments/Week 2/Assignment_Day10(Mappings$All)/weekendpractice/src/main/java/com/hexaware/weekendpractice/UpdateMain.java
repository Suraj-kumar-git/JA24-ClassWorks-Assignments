package com.hexaware.weekendpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.weekendpractice.entity.DepartmentOneToMany;

public class UpdateMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
//		Query query = session.createNamedQuery("updateDepartmentById");
//		query.setParameter(1,"Angular-FSD");
//		query.setParameter(2,103);
//		session.update(query);
		
		// The above code is not working
		DepartmentOneToMany dept = session.get(DepartmentOneToMany.class, 103);
		dept.setDepartmentName("Angular-FSD");
		session.persist(dept);
		
		txn.commit();
		session.close();
	}
}
