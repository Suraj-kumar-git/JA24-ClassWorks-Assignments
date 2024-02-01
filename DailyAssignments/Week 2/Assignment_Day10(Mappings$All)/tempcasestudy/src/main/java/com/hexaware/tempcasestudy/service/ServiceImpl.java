package com.hexaware.tempcasestudy.service;

import java.util.List;

import com.hexaware.tempcasestudy.dao.IDao;
import com.hexaware.tempcasestudy.entity.Customer;
import com.hexaware.tempcasestudy.entity.Loan;

public class ServiceImpl implements IService {
	
	IDao dao;

	@Override
	public void login(String role, String username, String password) {
		dao.login(role, username, password);
	}

	@Override
	public void register(Customer customer) {
		dao.register(customer);
	}

	@Override
	public double interestCalculator(double principal, double rate, int tenure) {
		dao.interestCalculator(principal, rate, tenure);
		return 0;
	}

	@Override
	public double emiCalculator(double principal, double rate, int tenure) {
		dao.emiCalculator(principal, rate, tenure);
		return 0;
	}

	@Override
	public List<Loan> customerViewAllLoans() {
		dao.customerViewAllLoans();
		return null;
	}

	@Override
	public List<Loan> adminViewAllLoans() {
		dao.adminViewAllLoans();
		return null;
	}

	@Override
	public void searchLoans(String loanType) {
		dao.searchLoans(loanType);
	}

	@Override
	public Customer searchCustomer(String username) {
		dao.searchCustomer(username);
		return null;
	}

	@Override
	public List<Loan> loanApplicationsForAdmin() {
		dao.loanApplicationsForAdmin();
		return null;
	}

	@Override
	public List<Loan> filterLoansByStatus(String status) {
		dao.filterLoansByStatus(status);
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers() {
		
		return null;
	}

	@Override
	public Customer viewCustomerDetails(String username) {
		dao.viewCustomerDetails(username);
		return null;
	}

	@Override
	public List<Loan> viewLoansOfCustomer(String username) {
		dao.viewLoansOfCustomer(username);
		return null;
	}

	@Override
	public Loan applyLoan(Loan loan) {
		dao.applyLoan(loan);
		return null;
	}

	@Override
	public void updateLoanStatus(String username, String status) {
		dao.updateLoanStatus(username, status);
	}

}
