package com.hexaware.springcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.springcore.dao.IDao;

@Service
public class ServiceImpl implements IService {
	
	@Autowired
	IDao dao;
	
	public void getService() {
		System.out.println("Service implemented");
		System.out.println("Dao called "+dao);
	}
}
