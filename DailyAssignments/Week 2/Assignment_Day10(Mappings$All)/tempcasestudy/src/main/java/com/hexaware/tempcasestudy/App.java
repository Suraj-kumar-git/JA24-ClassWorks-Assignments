package com.hexaware.tempcasestudy;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hexaware.tempcasestudy.entity.Customer;
import com.hexaware.tempcasestudy.entity.Loan;

/**
 * @author navne
 * @date 27/01/2024
 *
 */
public class App {
	public static void main( String[] args ){
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setAddress("Muzaffarpur");
		customer.setCountry("India");
		customer.setCreditScore(756);
		customer.setDob(LocalDate.now());
		customer.setEmail("Suraj@qwe");
		customer.setPassword("Suraj");
		customer.setState("Bihar");
		customer.setUserFirstName("Suraj");
		customer.setUserFirstName("Kumar");
		
		Loan loan1 = new Loan();
		loan1.setCustomer(customer);
		loan1.setInterestRate(12.0);
		loan1.setLoanApplicationDate(LocalDate.now());
		loan1.setLoanType("Home");
		loan1.setPrincipal(234121.0);
		loan1.setTenureInMonths(12);
		loan1.setStatus("Pending");
		Loan loan2 = new Loan();
		loan2.setCustomer(customer);
		loan2.setInterestRate(12.0);
		loan2.setLoanApplicationDate(LocalDate.now());
		loan2.setLoanType("Home");
		loan2.setPrincipal(234121.0);
		loan2.setTenureInMonths(12);
		loan2.setStatus("Pending");
		Loan loan3 = new Loan();
		loan3.setCustomer(customer);
		loan3.setInterestRate(12.0);
		loan3.setLoanApplicationDate(LocalDate.now());
		loan3.setLoanType("Home");
		loan3.setPrincipal(234121.0);
		loan3.setTenureInMonths(12);
		loan3.setStatus("Pending");
		
		
		customer.addLoan(loan1);
		customer.addLoan(loan2);
		customer.addLoan(loan3);
		session.persist(customer);
		txn.commit();
		session.close();
	}
}
