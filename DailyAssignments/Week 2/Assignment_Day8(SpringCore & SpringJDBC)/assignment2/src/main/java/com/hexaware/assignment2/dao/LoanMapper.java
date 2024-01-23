package com.hexaware.assignment2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hexaware.assignment2.model.Loan;

public class LoanMapper implements RowMapper<Loan> {

	@Override
	public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Loan(rs.getInt("loanid"),rs.getString("loantype"),rs.getDouble("Amount"),rs.getInt("duration"),rs.getString("status"));
	}



}
