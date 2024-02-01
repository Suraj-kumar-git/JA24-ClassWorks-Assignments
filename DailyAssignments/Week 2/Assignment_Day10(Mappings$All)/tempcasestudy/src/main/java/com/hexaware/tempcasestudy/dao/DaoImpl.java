package com.hexaware.tempcasestudy.dao;

import java.util.List;

import com.hexaware.tempcasestudy.entity.Customer;
import com.hexaware.tempcasestudy.entity.Loan;

public class DaoImpl implements IDao {
	
//	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//	private Session session = sessionFactory.openSession();
	
	
	@Override
	public void login(String role, String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double interestCalculator(double principal, double rate, int tenure) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double emiCalculator(double principal, double rate, int tenure) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Loan> customerViewAllLoans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> adminViewAllLoans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void searchLoans(String loanType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer searchCustomer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> loanApplicationsForAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> filterLoansByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomerDetails(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> viewLoansOfCustomer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan applyLoan(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLoanStatus(String username, String status) {
		// TODO Auto-generated method stub
		
	}

}
