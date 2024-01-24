package com.hexaware.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springhibernate.dao.IDao;
import com.hexaware.springhibernate.entity.Loan;

@Service
public class ServiceImpl implements IService{

	
	@Autowired
	IDao dao;

	@Override
	public boolean createLoan(Loan loan) {
		return dao.createLoan(loan);
	}

	@Override
	public boolean updateLoan(Loan loan) {
		return dao.updateLoan(loan);
	}

	@Override
	public boolean deleteLoan(int id) {
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
