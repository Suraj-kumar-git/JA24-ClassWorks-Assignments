package com.hexaware.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.springbatch.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
