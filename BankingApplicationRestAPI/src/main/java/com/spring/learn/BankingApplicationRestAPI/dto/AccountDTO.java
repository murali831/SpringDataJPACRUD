package com.spring.learn.BankingApplicationRestAPI.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountDTO {
	private long accountId;
	private long accountNumber;
	private String accountHolderName;
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
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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
	public AccountDTO(long accountId,long accountNumber, String accountHolderName, double balance) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	public AccountDTO() {
		super();
	}
	
}
