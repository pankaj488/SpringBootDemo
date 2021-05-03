package com.pankaj.controller;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 * This Controller will return response in asynchronous way.
 * 
 * @author pansingh15
 *
 */
@RestController
@RequestMapping("/asyncAPI")
public class AsyncRestController {

	@GetMapping
	@RequestMapping(path = "/executeAsync")
	public WebAsyncTask<String> executeAsync(@RequestParam(name = "username",defaultValue = "ORFI")  final String demoUser) {
		System.out.println("Service started::  Thread name which is calling endpoint :: "+Thread.currentThread().getName());
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(" Thread name which is returning endpoint :: "+Thread.currentThread().getName());
				return "Execution of callable is success";
			}
		};
		WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(2000, callable);
		
		return webAsyncTask;
	}

}
