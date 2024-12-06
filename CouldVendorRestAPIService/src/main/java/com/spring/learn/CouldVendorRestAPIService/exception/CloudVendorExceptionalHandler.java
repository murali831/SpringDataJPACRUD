package com.spring.learn.CouldVendorRestAPIService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionalHandler {
	
	@ExceptionHandler(CloudVendorNotFoundException.class)
	public ResponseEntity<ErrorDetails> vendorNotFoundException(CloudVendorNotFoundException exception) {
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(),
				exception.getCause(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(CloudVendorNotFoundException.class)
//	public ResponseEntity<ErrorDetails> vendorNotFoundException(CloudVendorNotFoundException exception,
//			WebRequest webRequest) {
//		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
//				webRequest.getDescription(false), "VENDOR_NOT_FOUND");
//		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
//	}
}
