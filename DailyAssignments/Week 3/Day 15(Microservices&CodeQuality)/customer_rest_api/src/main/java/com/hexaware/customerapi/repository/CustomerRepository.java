package com.hexaware.customerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.customerapi.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("update Customer c set productId = :productId where c.customerId=:customerId")
	@Modifying
	void update(int customerId, int productId);

}
