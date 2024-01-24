package com.hexaware.assignment3.service;

import java.util.List;

import com.hexaware.assignment3.entity.Loan;

public interface IService {
	int createLoan(Loan loan);
	int updateLoan(Loan loan);
	int deleteLoan(int id);
	Loan selectLoanById(int id);
	List<Loan> selectLoanByStatus(String status);
	List<Loan> selectLoanByType(String type);
	List<Loan> selectAllLoans();
}
