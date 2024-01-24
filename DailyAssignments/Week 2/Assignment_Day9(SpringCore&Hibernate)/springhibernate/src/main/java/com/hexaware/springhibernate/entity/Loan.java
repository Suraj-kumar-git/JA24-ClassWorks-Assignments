package com.hexaware.springhibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="loan2")
@Component
@NamedQueries({
	@NamedQuery(name="getAllLoans",query="select l from Loan l"),
	@NamedQuery(name="getAllLoansByType",query="select l from Loan l where l.loanType = ?1")
})
public class Loan {
	
	@Id
	private int loanId;
	private String loanType;
	private double amount;
	private int duration;
	private String status;
	public Loan() {
		super();
	}
	public Loan(int loanId, String loanType, double loanAmount, int duration) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.amount = loanAmount;
		this.duration = duration;
	}
	public Loan(int loanId, String loanType, double loanAmount, int duration,String status) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.amount = loanAmount;
		this.duration = duration;
		this.status=status;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return amount;
	}
	public void setLoanAmount(double loanAmount) {
		this.amount = loanAmount;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", loanAmount=" + amount + ", duration="
				+ duration + ", status=" + status + "]";
	}
	
	
	
}
