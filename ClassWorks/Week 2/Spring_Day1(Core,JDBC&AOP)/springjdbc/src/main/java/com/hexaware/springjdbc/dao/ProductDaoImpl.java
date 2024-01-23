package com.hexaware.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hexaware.springjdbc.model.Product;

@Repository
public class ProductDaoImpl implements IProductDao {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProductDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
		System.out.println("Jdbc template");
	}
	
	@Override
	public boolean createProduct(Product product) {
		String insertQuery = "insert into product(pid,pname,price) values(?,?,?)";
		int count=jdbcTemplate.update(insertQuery,product.getProductId(),product.getProductName(),product.getPrice());
		return count>0;
	}

	@Override
	public boolean updateProduct(Product product) {
		String updateQuery = "update product set pname=?,price=? where pid=?";
		int count=jdbcTemplate.update(updateQuery,product.getProductName(),product.getPrice(),product.getProductId());
		return count>0;
	}

	@Override
	public boolean deleteProductById(int productId) {
		String deleteQuery = "delete from product where pid=?";
		int count=jdbcTemplate.update(deleteQuery,productId);
		return count>0;
	}

	@Override
	public Product selectProductById(int productId) {
		String selectOneQuery="select pid,pname,price from product where pid=?";
		Product product = jdbcTemplate.queryForObject(selectOneQuery,new ProductMapper(),productId);
		return product;
	}

	@Override
	public List<Product> selectAllProducts() {
		String selectAllQuery ="select pid,pname,price from product";
		List<Product> products = jdbcTemplate.query(selectAllQuery,new ProductMapper());
		return products;
	}

	

}
