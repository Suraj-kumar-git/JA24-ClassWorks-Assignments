package com.hexaware.assignment2.dao;

import java.util.List;

import com.hexaware.assignment2.model.Loan;

public interface IDao {
	int createLoan(Loan loan);
	int updateLoan(Loan loan);
	int deleteLoan(int id);
	Loan selectLoanById(int id);
	List<Loan> selectLoanByStatus(String status);
	List<Loan> selectLoanByType(String type);
	List<Loan> selectAllLoans();
}
