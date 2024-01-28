package com.hexaware.weekendpractice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.weekendpractice.entity.DepartmentOneToMany;
import com.hexaware.weekendpractice.entity.EmployeeOneToMany;

/**
 * @author Suraj Kumar
 * @date 27-01-2024
 * @task weekend assignment
 */
public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		// ONE-TO-ONE
//		EmployeeOneToOne emp = new EmployeeOneToOne(3, "Palash", 85000);
//		AddressOneToOne address = new AddressOneToOne(103,"Indore");
//		emp.setAddress(address);
//		address.setEmp(emp);
//		session.persist(emp);
//		 // ONE-TO-MANY
		EmployeeOneToMany emp1= new EmployeeOneToMany(6,"Surbhi",50000); 
		EmployeeOneToMany emp2= new EmployeeOneToMany(7,"Sheshank",60000); 
		EmployeeOneToMany emp3= new EmployeeOneToMany(8,"Yash",70000); 
		EmployeeOneToMany emp4= new EmployeeOneToMany(9,"K Ishwari",25000); 
		EmployeeOneToMany emp5= new EmployeeOneToMany(10,"Ratnesh",45000);
		DepartmentOneToMany dept = new DepartmentOneToMany(102,"React-FSD");
		dept.addEmployee(emp1);
		dept.addEmployee(emp2);
		dept.addEmployee(emp3);
		dept.addEmployee(emp4);
		dept.addEmployee(emp5);
		session.persist(dept);
		
		// MANY-TO-MANY
//		StudentManyToMany stu1 = new StudentManyToMany(1,"Suraj");
//		StudentManyToMany stu2 = new StudentManyToMany(2,"Palash");
//		StudentManyToMany stu3 = new StudentManyToMany(3,"Ratnesh");
//		StudentManyToMany stu4 = new StudentManyToMany(4,"Sheshank");
//		StudentManyToMany stu5 = new StudentManyToMany(5,"Yash");
//		CourseManyToMany cr1 = new CourseManyToMany(1,"Java-FSD",35);
//		CourseManyToMany cr2 = new CourseManyToMany(2,"React-FSD",30);
//		CourseManyToMany cr3 = new CourseManyToMany(3,"Java-FSD2",15);
//		CourseManyToMany cr4 = new CourseManyToMany(4,"Java-FSD3",25);
//		CourseManyToMany cr5 = new CourseManyToMany(5,"React-FSD3",50);
//		CourseManyToMany cr6 = new CourseManyToMany(6,"React-FSD2",13);
//		
//		stu1.addCourse(cr6);
//		stu1.addCourse(cr5);
//		stu2.addCourse(cr6);
//		stu3.addCourse(cr2);
//		stu3.addCourse(cr3);
//		stu3.addCourse(cr1);
//		stu4.addCourse(cr5);
//		stu4.addCourse(cr3);
//		stu5.addCourse(cr2);
//		stu4.addCourse(cr1);
//		stu2.addCourse(cr4);
//		stu3.addCourse(cr4);
//		
//		session.persist(stu1);
//		session.persist(stu2);
//		session.persist(stu3);
//		session.persist(stu4);
//		session.persist(stu5);

		txn.commit();
		session.close();
	}

}
