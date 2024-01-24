package com.hexaware.springhibernate.service;

import java.util.List;

import com.hexaware.springhibernate.entity.Loan;

public interface IService {
	boolean createLoan(Loan loan);
	boolean updateLoan(Loan loan);
	boolean deleteLoan(int id);
	Loan selectLoanById(int id);
	List<Loan> selectLoanByStatus(String status);
	List<Loan> selectLoanByType(String type);
	List<Loan> selectAllLoans();
}
