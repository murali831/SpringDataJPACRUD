package com.spring.learn.BankingApplicationRestAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long accountId;
	
	private long accountNumber;
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name = "account_holder_name")
	private String accountHolderName;
	
	@Column(name = "account_balance")
	private double balance;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + " accountNumber " + accountNumber + ", accountHolderName=" + accountHolderName + ", balance=" + balance
				+ "]";
	}

	public Account(long accountId,long accountNumber, String accountHolderName, double balance) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public Account() {
		super();
	}
	
	
}
