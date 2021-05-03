package com.pankaj.controller;

import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import com.pankaj.service.CallableTask;

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
	public WebAsyncTask<String> executeAsync(@RequestParam(name = "username",defaultValue = "ORFI")  final String username) {
		System.out.println("Service started::  Thread name which is calling endpoint :: "+Thread.currentThread().getName());
		CallableTask callable = new CallableTask(username);
		WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(20000, callable);
		webAsyncTask.onTimeout(() -> {
			System.out.println("onTimeout...");
			return "Request timed out...";
		});
		webAsyncTask.onError(() -> {
			System.out.println("onError...");
			return "Some error occurred...";
		});
		webAsyncTask.onCompletion(() -> {
			System.out.println("onCompletion...");
		});
		return webAsyncTask;
	}



}
