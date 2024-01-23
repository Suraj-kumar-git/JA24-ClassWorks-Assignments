package com.hexaware.assignment2.model;

import org.springframework.stereotype.Component;

@Component
public class Loan {
	private int loanId;
	private String loanType;
	private double loanAmount;
	private int duration;
	private String status;
	public Loan() {
		super();
	}
	public Loan(int loanId, String loanType, double loanAmount, int duration) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.duration = duration;
	}
	public Loan(int loanId, String loanType, double loanAmount, int duration,String status) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
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
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
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
		return "Loan [loanId=" + loanId + ", loanType=" + loanType + ", loanAmount=" + loanAmount + ", duration="
				+ duration + ", status=" + status + "]";
	}
	
	
	
}
