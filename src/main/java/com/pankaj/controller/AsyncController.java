package com.pankaj.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.model.EmployeeAddresses;
import com.pankaj.model.EmployeeNames;
import com.pankaj.model.EmployeePhone;
import com.pankaj.service.AsyncService;
/**
 * This controller is calling asyncService which is calling third party asynchronous. However this API is not asychronous.
 * @author pansingh15
 *
 */

@RestController
@RequestMapping("/async")
// https://www.thetechnojournals.com/2019/10/asynchronous-rest-service.html

public class AsyncController {
	private static Logger log = LoggerFactory.getLogger(AsyncController.class);
	@Autowired
	private AsyncService asyncService;

	@SuppressWarnings("unchecked")
	@GetMapping(path = "/testAsync", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity testAsync() throws InterruptedException, ExecutionException {
		log.info("Start testAsync");
		CompletableFuture<EmployeeAddresses> employeeAddressFuture = asyncService.getEmployeeAddress();
		CompletableFuture<EmployeeNames> employeeNameFuture = asyncService.getEmployeeName();
		CompletableFuture<EmployeePhone> empployeePhoneFuture = asyncService.getEmployeePhone();
		// Wait till all done
		log.info("Wait till all done");
		Void completableFuture = CompletableFuture.allOf(employeeAddressFuture,employeeNameFuture,empployeePhoneFuture).join();
		log.info("EmployeeAddress--> " + employeeAddressFuture.get());
        log.info("EmployeeName--> " + employeeNameFuture.get());
        log.info("EmployeePhone--> " + empployeePhoneFuture.get());
        return new ResponseEntity(completableFuture,HttpStatus.ACCEPTED);
	}

}
