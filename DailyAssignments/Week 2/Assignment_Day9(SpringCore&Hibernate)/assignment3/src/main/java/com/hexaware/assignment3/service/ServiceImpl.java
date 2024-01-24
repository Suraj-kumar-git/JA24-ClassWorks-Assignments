package com.hexaware.assignment3.service;

import java.util.List;

import com.hexaware.assignment3.dao.DaoImpl;
import com.hexaware.assignment3.dao.IDao;
import com.hexaware.assignment3.entity.Loan;

public class ServiceImpl implements IService{

	IDao dao = new DaoImpl();

	@Override
	public int createLoan(Loan loan) {
		return dao.createLoan(loan);
	}

	@Override
	public int updateLoan(Loan loan) {
		return dao.updateLoan(loan);
	}

	@Override
	public int deleteLoan(int id) {
		return dao.deleteLoan(id);
	}

	@Override
	public Loan selectLoanById(int id) {
		return dao.selectLoanById(id);
	}

	@Override
	public List<Loan> selectLoanByStatus(String status) {
		return dao.selectLoanByStatus(status);
	}

	@Override
	public List<Loan> selectLoanByType(String type) {
		return dao.selectLoanByType(type);
	}

	@Override
	public List<Loan> selectAllLoans() {
		return dao.selectAllLoans();
	}
	
}
