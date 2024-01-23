package com.hexaware.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.aop.config.AppConfig;
import com.hexaware.aop.exception.InsufficientFundException;
import com.hexaware.aop.service.BankService;

/*
 * @Author: Suraj
 * Date: 23-an-2024
*/
public class App 
{
    public static void main( String[] args ){
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	BankService service = context.getBean(BankService.class);
    	
    	service.login();
    	service.deposit();
    	service.withdraw();
    	service.fundTransfer();
    	try {
			service.checkBalance(0);
		} catch (InsufficientFundException e) {
			e.printStackTrace();
		}
    }
}
