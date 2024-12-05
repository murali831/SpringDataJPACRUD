package com.spring.learn.BankingApplicationRestAPI.controller.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionalHandler {
	
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<ErrorDetails> handleAccountException(AccountException exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(
												LocalDateTime.now(),
												exception.getMessage(),
												webRequest.getDescription(false),
												"ACCOUNT_NOT_FOUND");
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccountNotHavingMinimumBalanceException.class)
	public ResponseEntity<ErrorDetails> handleAccountNotHavingMinimumBalanceException(AccountNotHavingMinimumBalanceException exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
													 exception.getMessage() ,
													 webRequest.getDescription(false),
													 "ACCOUNT_NOT_HAVING_MINIMUM_BALANCE_EXCEPTION");
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
							
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGenericException(AccountException exception, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(
												LocalDateTime.now(),
												exception.getMessage(),
												webRequest.getDescription(false),
												"INTERNAL_SERVER_ERROR");
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
