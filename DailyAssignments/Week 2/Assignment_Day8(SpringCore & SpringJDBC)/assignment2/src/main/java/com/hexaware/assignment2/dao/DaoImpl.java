package com.hexaware.assignment2.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hexaware.assignment2.model.Loan;

@Repository
public class DaoImpl implements IDao{

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public DaoImpl(DataSource datasource) {
		jdbcTemplate= new JdbcTemplate(datasource);
		System.out.println("Connection properties is sent to  JdbcTemplate");
	}
	@Override
	public int createLoan(Loan loan) {
		String createQuery ="insert into loan(loanId,loantype,amount,duration) values(?,?,?,?)";
		int count=jdbcTemplate.update(createQuery,loan.getLoanId(),loan.getLoanType(),loan.getLoanAmount(),loan.getDuration());
		return count;
	}

	@Override
	public int updateLoan(Loan loan) {
		String updateQuery ="update loan set loantype=?,amount=?,duration=? where loanid=?";
		int count=jdbcTemplate.update(updateQuery,loan.getLoanType(),loan.getLoanAmount(),loan.getDuration(),loan.getLoanId());
		return count;
	}

	@Override
	public int deleteLoan(int id) {
		String deleteQuery ="delete from loan where loanid=?";
		int count=jdbcTemplate.update(deleteQuery,id);
		return count;
	}

	@Override
	public Loan selectLoanById(int id) {
		String selectOneQuery ="select loanid,loantype,amount,duration,status from loan where loanid=?";
		Loan loan=jdbcTemplate.queryForObject(selectOneQuery,new LoanMapper(),id);
		return loan;
	}

	@Override
	public List<Loan> selectLoanByStatus(String status) {
		String selectStatusQuery ="select loanid,loantype,amount,duration,status from loan where status=?";
		List<Loan> loansByStatus =jdbcTemplate.query(selectStatusQuery,new LoanMapper(),status);
		return loansByStatus;
	}

	@Override
	public List<Loan> selectLoanByType(String type) {
		String selectTypeQuery ="select loanid,loantype,amount,duration,status from loan where loantype=?";
		List<Loan> loansByType =jdbcTemplate.query(selectTypeQuery,new LoanMapper(),type);
		return loansByType;
	}

	@Override
	public List<Loan> selectAllLoans() {
		String selectAllQuery ="select loanid,loantype,amount,duration,status from loan";
		List<Loan> allLoans =jdbcTemplate.query(selectAllQuery,new LoanMapper());
		return allLoans;
	}

}
