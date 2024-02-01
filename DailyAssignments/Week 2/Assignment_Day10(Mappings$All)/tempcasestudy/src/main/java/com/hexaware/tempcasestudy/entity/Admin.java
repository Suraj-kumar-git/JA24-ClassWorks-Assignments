package com.hexaware.tempcasestudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int AdminId;
	@Column(name="firstName")
	private String adminFirstName;
	@Column(name="lastName")
	private String adminLastName;
	private String password;
	@Column(columnDefinition="varchar(5) default 'Admin'")
	private String role;
}
