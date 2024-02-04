package com.hexaware.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.restapi.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer> {

}
