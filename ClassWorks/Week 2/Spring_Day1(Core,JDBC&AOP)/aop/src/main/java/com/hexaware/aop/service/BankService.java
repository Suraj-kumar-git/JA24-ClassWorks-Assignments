package com.hexaware.aop.service;

import org.springframework.stereotype.Service;

import com.hexaware.aop.exception.InsufficientFundException;

@Service
public class BankService {
	
	public void login() {
		System.out.println("Login Success");
	}
	
	public void deposit() {
		System.out.println("Amount Deposited Successfully");
	}
	
	public void withdraw() {
		System.out.println("Amount withdrawl Successfully");
	}
	
	public void fundTransfer() {
		System.out.println("Fund Transafered Successfully");
	}
	
	public int checkBalance(int acno) throws InsufficientFundException {
		int balance=0;
		if(acno>0) {
			balance=5000;
		}
		else {
			throw new InsufficientFundException("Insufficient Balance");
		}
		return balance;
	}
}
