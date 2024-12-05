package com.spring.learn.BankingApplicationRestAPI.controller.exception;

public class AccountNotHavingMinimumBalanceException extends Exception {
	
	public AccountNotHavingMinimumBalanceException(String message) {
		super(message);
	}

}
