package com.revature.project0.userInfo;

import java.io.Serializable;

import java.util.Objects;


public class User  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String userName;
	private String firstName;
	private String lastName;
	private Integer accountNumber;
	private Double balance;
	private UserType userType;
	private LoanType loanType;


public User() {
	super();
	this.userType = UserType.USER;
	
	}

public User(Integer id, String username, String email, Integer accountnumber, Double balance) {
	this();
	this.id = id;
	this.userName = username;
	this.email = email;
	this.accountNumber = accountnumber;
	this.balance = balance;
}
public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public Integer getAccountNumber() {
	return accountNumber;
}


public void setAccountNumber(Integer accountNumber) {
	this.accountNumber = accountNumber;
}


public Double getBalance() {
	return balance;
}


public void setBalance(Double balance) {
	this.balance = balance;
}


public UserType getUserType() {
	return userType;
}


public void setUserType(UserType userType) {
	this.userType = userType;
}


public LoanType getLoanType() {
	return loanType;
}


public void setLoanType(LoanType loanType) {
	this.loanType = loanType;
}


@Override
public int hashCode() {
	return Objects.hash(accountNumber, balance, email, firstName, id, lastName, loanType, userType);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(balance, other.balance)
			&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
			&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName) && loanType == other.loanType
			&& userType == other.userType;
}


@Override
public String toString() {
	return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", accountNumber=" + accountNumber + ", balance=" + balance + ", userType=" + userType + ", loanType="
			+ loanType + "]";
}

}