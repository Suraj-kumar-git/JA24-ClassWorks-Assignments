package com.hexaware.tempcasestudy.service;

import java.util.List;

import com.hexaware.tempcasestudy.entity.Customer;
import com.hexaware.tempcasestudy.entity.Loan;

public interface IService {
	void login(String role, String username, String password);

	void register(Customer customer);

	double interestCalculator(double principal, double rate, int tenure);

	double emiCalculator(double principal, double rate, int tenure);

	List<Loan> customerViewAllLoans();

	List<Loan> adminViewAllLoans();

	void searchLoans(String loanType);

	Customer searchCustomer(String username);

	List<Loan> loanApplicationsForAdmin();

	List<Loan> filterLoansByStatus(String status);

	List<Customer> viewAllCustomers();

	Customer viewCustomerDetails(String username);

	List<Loan> viewLoansOfCustomer(String username);

	Loan applyLoan(Loan loan);

	void updateLoanStatus(String username, String status);

}
