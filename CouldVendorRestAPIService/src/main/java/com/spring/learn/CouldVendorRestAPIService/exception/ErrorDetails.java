package com.spring.learn.CouldVendorRestAPIService.exception;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
 private final String message ;
 private final Throwable cause ;
 private final HttpStatus https;
public String getMessage() {
	return message;
}
public Throwable getCause() {
	return cause;
}
public HttpStatus getHttps() {
	return https;
}
public ErrorDetails(String message, Throwable cause, HttpStatus https) {
	super();
	this.message = message;
	this.cause = cause;
	this.https = https;
}
}
