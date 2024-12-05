package com.spring.learn.BankingApplicationRestAPI.controller.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	LocalDateTime localDateTime;
	String message;
	String details;
	String errorCode;
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	@Override
	public String toString() {
		return "ErrorDetails [localDateTime=" + localDateTime + ", message=" + message + ", details=" + details
				+ ", errorCode=" + errorCode + "]";
	}
	public ErrorDetails(LocalDateTime localDateTime, String message, String details, String errorCode) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.details = details;
		this.errorCode = errorCode;
	}
	public ErrorDetails() {
		super();
	}
	
}
