package com.pankaj.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralExceptionHandling {
	/*
	 * @ExceptionHandler(value = Exception.class) public ResponseEntity<String>
	 * errorcallingThirdParty() { return new
	 * ResponseEntity<>("List can not be loaded due to third party down",HttpStatus.
	 * INTERNAL_SERVER_ERROR ); }
	 */
//	@Primary
	//@ExceptionHandler(value = Exception.class) 
	public ResponseEntity<String> exceptionAsync() {
		return new ResponseEntity<>("Exception from Async Service", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
