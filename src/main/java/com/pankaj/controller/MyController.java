package com.pankaj.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ashi.IOuter;

@RestController
@RequestMapping("/users")
public class MyController {
	Logger log = LoggerFactory.getLogger(MyController.class);
	
	
	@Qualifier("outerPackageBean")
	@Autowired
	IOuter iOuter;
	@Autowired
	@Qualifier("nameListMembers")
	List<String> nameList1;
	
	@GetMapping(path = "/hello")
	public String hello() {
		return "Hello !! I am azure";
		
	}
	
	@GetMapping(path = "/ping")
	public String ping() throws Exception {
		//return "Working !!";
		//http://dummy.restapiexample.com/api/v1/employees
		RestTemplate restTemplate = new RestTemplate();
		URI uri = null;
		try {
			uri = new URI("http://dummy.restapiexample.com/api/v1/employees"); //
			//ResponseEntity<Object> responseEntity = restTemplate.getForEntity(uri, null);
			ResponseEntity<Object> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, Object.class);
			System.out.println(responseEntity.getBody());
		} catch (Exception e) {
			throw e;
		}
		//return iOuter.getMsg();
		return nameList1.toString();
	}
	
	/*
	 * @GetMapping(path = "/async") public String pingAsync() throws Exception {
	 * //http://dummy.restapiexample.com/api/v1/employees //RestTemplate
	 * restTemplate = new RestTemplate();
	 * 
	 * @SuppressWarnings("deprecation") AsyncRestTemplate async = new
	 * AsyncRestTemplate (); //WebClie URI uri = null; try { uri = new
	 * URI("http://dummy.restapiexample.com/api/v1/employees"); //
	 * //ResponseEntity<Object> responseEntity = restTemplate.getForEntity(uri,
	 * null); ResponseEntity<Object> responseEntity = restTemplate.exchange(uri,
	 * HttpMethod.GET, null, Object.class);
	 * System.out.println(responseEntity.getBody()); } catch (Exception e) { throw
	 * e; } //return iOuter.getMsg(); return nameList1.toString(); }
	 */
	
	
	/*
	 * @GetMapping( path = "/secret") //@PreAuthorize('hasRole()') public String
	 * restrictedMethod() { return "Here is secret passcode";
	 * 
	 * 
	 * }
	 */
	
	
	
}
