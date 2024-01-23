package com.hexaware.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {
	
	@Pointcut("execution(* com.hexaware.aop.service.BankService.login())")
	public void authentication() {  //Pointcut-1
		
	}
	
	@Pointcut("execution(* com.hexaware.aop.service.BankService.*())")
	public void authorization() {   //Pointcut-1
		
	}
	
	@Before("authentication() && authorization() ")
	public void authenticationAndAuthorization() {	//join Point-1
		System.out.println("Login Verified...User login success and authorization is verified");
	}
}
