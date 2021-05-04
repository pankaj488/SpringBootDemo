package com.pankaj.service;
 
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pankaj.model.EmployeeAddresses;
import com.pankaj.model.EmployeeNames;
import com.pankaj.model.EmployeePhone;
 

 
@Service
public class AsyncService {
 
    private static Logger log = LoggerFactory.getLogger(AsyncService.class);
 
    @Autowired
    private RestTemplate restTemplate;
 
	/*
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */
 
    @Async("asyncExecutor")
    public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException 
    {
        log.info("getEmployeeName starts");
 
        EmployeeNames employeeNameData = restTemplate.getForObject("http://localhost:2025/names", EmployeeNames.class);
 
        log.info("employeeNameData, {}", employeeNameData);
        Thread.sleep(1000L);    //Intentional delay
        log.info("employeeNameData completed");
        return CompletableFuture.completedFuture(employeeNameData);
    }
 
    @Async("asyncExecutor")
    public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException 
    {
        log.info("getEmployeeAddress starts");
 
        EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:2025/addresses", EmployeeAddresses.class);
 
        log.info("employeeAddressData, {}", employeeAddressData);
        Thread.sleep(1000L);    //Intentional delay
        log.info("employeeAddressData completed");
        return CompletableFuture.completedFuture(employeeAddressData);
    }
 
    @Async("asyncExecutor")
    public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException 
    {
        log.info("getEmployeePhone starts");
 
        EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:2025/phones", EmployeePhone.class);
       
        log.info("employeePhoneData, {}", employeePhoneData);
        Thread.sleep(1000L);    //Intentional delay
        log.info("employeePhoneData completed");
        return CompletableFuture.completedFuture(employeePhoneData);
    }
    @Async("asyncExecutor")
    public CompletableFuture<EmployeePhone> getEmployeePhone1() throws InterruptedException 
    {
        log.info("getEmployeePhone1 starts");
 
        EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:2025/phones", EmployeePhone.class);
       
        log.info("employeePhoneData1, {}", employeePhoneData);
        Thread.sleep(1000L);    //Intentional delay
        log.info("employeePhoneData1 completed");
        return CompletableFuture.completedFuture(employeePhoneData);
    }
}