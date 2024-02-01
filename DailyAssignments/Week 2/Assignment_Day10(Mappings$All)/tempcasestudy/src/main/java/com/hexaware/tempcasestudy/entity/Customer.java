package com.hexaware.tempcasestudy.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// We have to set the initial value for id field in the database
	private Long customerId;

	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
	private Set<Loan> loans = new HashSet<>();
	
	@Column(name = "firstName")
	private String userFirstName;
	@Column(name = "lastName")
	private String userLastName;
	private String username;
	private String password;
	private LocalDate dob;
	private String address;
	@Column(columnDefinition = "varchar(10) default 'regular'")
	private String role;
	private String state;
	@Column(columnDefinition = "varchar(10) default 'India'")
	private String country;
	private String email;
	private int creditScore;
	
	
	public Set<Loan> getLoans() {
		return loans;
	}

	public void addLoan(Loan loan) {
		Set<Loan> loans = getLoans();
		loans.add(loan);
	}

	public Customer(String userFirstName, String userLastName, String username, String password,
			LocalDate dob, String address, String state, String country, String email, int creditScore) {
		super();
//		this.customerId = customerId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.creditScore = creditScore;
	}

	public Customer(String userFirstName, String userLastName, String password, LocalDate dob, String address,
			String state, String email, int creditScore) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.state = state;
		this.email = email;
		this.creditScore = creditScore;
	}

	public Customer() {
		super();
	}

	public Long getCustomerId() {
		return customerId;
	}
	

	public String getRole() {
		return role;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	@PrePersist
	private void generateUsername() {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//		String dobString = dateFormat.format(dob);
//		String userName = userFirstName + Math.min(userLastName.length(), 3) + "_@"+ password.length();
		setUsername("DefaultUserName");
		
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", loans=" + loans + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", username=" + username + ", password=" + password + ", dob="
				+ dob + ", address=" + address + ", role=" + role + ", state=" + state + ", country=" + country
				+ ", email=" + email + ", creditScore=" + creditScore + "]";
	}
	
}
