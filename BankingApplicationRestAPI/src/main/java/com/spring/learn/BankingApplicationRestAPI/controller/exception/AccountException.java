package com.spring.learn.BankingApplicationRestAPI.controller.exception;

public class AccountException extends RuntimeException {

	public AccountException(String message) {
		super(message);
	}

}
