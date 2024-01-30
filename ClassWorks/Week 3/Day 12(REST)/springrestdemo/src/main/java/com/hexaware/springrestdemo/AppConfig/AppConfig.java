package com.hexaware.springrestdemo.AppConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl(env.getProperty("jdbc.url"));
		datasource.setUsername(env.getProperty("jdbc.username"));
		datasource.setPassword(env.getProperty("jdbc.password"));
		return datasource;
	}

	/*
	 * **** This we can use if we dont want to read data from ****
	 * 
	 * @Bean public DataSource getDataSource() {
	 * datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	 * datasource.setUrl("jdbc:mysql://localhost:3306/fsd");
	 * datasource.setUsername("root"); datasource.setPassword("73524Idea#"); return
	 * datasource; }
	 */

	/*
	 * This is not working...I dont know why?
	 * 
	 * @Bean public DataSource getDataSource() { DriverManagerDataSource datasource
	 * = new DriverManagerDataSource(); datasource.setUrl(env.getProperty("url"));
	 * datasource.setUrl(env.getProperty("uname"));
	 * datasource.setUrl(env.getProperty("password")); return datasource; }
	 */
}
