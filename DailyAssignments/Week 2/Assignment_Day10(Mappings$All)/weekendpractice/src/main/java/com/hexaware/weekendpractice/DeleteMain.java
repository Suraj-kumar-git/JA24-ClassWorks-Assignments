package com.hexaware.weekendpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class DeleteMain {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
//		Query query = session.createNamedQuery("deleteEmployeeById");
//		query.setParameter(1,9);
//		query.executeUpdate();
//		 //OR
//		EmployeeOneToMany emp = session.get(EmployeeOneToMany.class,8);
//		session.delete(emp);
		
		String delete= "delete from emp1tomany where eid=?";
		NativeQuery query = session.createNativeQuery(delete);
		query.setParameter(1,1);
		query.executeUpdate();
		
		txn.commit();
		session.close();
	}

}
