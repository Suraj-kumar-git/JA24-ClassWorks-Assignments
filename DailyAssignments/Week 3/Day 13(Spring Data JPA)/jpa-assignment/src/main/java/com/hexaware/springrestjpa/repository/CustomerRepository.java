package com.hexaware.springrestjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.springrestjpa.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	List<Customer> findByUsername(String username);
	
	@Query("delete from Customer c where c.username=?1")
	@Modifying
	int deleteCustomerByUsername(String username);
	
}
