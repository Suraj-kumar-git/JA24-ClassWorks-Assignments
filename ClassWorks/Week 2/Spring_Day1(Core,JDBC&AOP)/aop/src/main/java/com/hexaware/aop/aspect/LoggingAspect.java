package com.hexaware.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect { //Aspect Class
	
	@Before("execution(* com.hexaware.aop.service.BankService.deposit())")
	public void beforeLogs() {
		System.out.println("\nLogs before any Bank Service");
	}
	
	@After("execution(* com.hexaware.aop.service.BankService.fundTransfer())")
	public void afterLogs() {
		System.out.println("\nLogs after any Bank Service");
	}
	
	@Around("execution(* com.hexaware.aop.service.BankService.withdraw())")
	public void aroundLogs() {
		System.out.println("\nLogs before & after any Bank Service");
	}
	
	@Pointcut("execution(* com.hexaware.aop.service.BankService.checkBalance(..))")
	public void afterReturningPointCut() {
		
	}
	
	@AfterReturning(pointcut="afterReturningPointCut()",returning="balance")
	public void afterReturningBalance(int balance) {
		System.out.println("\nLogs after returning balance amount: "+balance);
	}
	
	@AfterThrowing(pointcut="afterReturningPointCut()",throwing="exp")
	public void afterThrowingException(Exception exp) {
		System.out.println("\nLogs after throwing Exception: "+exp.getMessage());
	}
}
