package com.hexaware.springcore.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements IDao{

	public void getDao() {
		System.out.println("Dao implemented");
	}
	
}
