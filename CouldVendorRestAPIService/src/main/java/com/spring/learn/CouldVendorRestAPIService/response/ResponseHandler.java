package com.spring.learn.CouldVendorRestAPIService.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpsstatus,
			Object responseObject) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		response.put("httpstatus", httpsstatus);
		response.put("data", responseObject);

		return new ResponseEntity<Object>(response, httpsstatus);
	}
}
