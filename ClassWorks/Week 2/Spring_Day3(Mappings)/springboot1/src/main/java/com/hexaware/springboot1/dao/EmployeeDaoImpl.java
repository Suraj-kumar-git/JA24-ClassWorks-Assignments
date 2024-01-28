package com.hexaware.springboot1.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public void checkService() {
		System.out.println("Service is working fine...");
	}

}
