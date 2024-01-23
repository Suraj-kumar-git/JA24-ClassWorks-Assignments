package com.hexaware.assignment2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.assignment2.dao.IDao;
import com.hexaware.assignment2.model.Loan;

@Service
public class ServiceImpl implements IService{

	@Autowired
	IDao dao;
	
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
