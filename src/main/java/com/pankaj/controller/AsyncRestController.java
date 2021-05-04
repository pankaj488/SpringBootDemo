package com.pankaj.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
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
	public WebAsyncTask<String> executeAsync(
			@RequestParam(name = "username", defaultValue = "ORFI") final String username) {
		System.out.println(
				"Service started::  Thread name which is calling endpoint :: " + Thread.currentThread().getName());
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

	@GetMapping("/r1")
	public Map<String, String> r1() {

		Instant now = Instant.now();

		Map<String, String> result = buildResult();

		doTask();

		System.out.println("r1 time consumption: " + ChronoUnit.SECONDS.between(now, Instant.now()) + " seconds");

		return result;
	}

	@GetMapping("/r2")
	public WebAsyncTask<Map<String, String>> r2() {

		Instant now = Instant.now();

		Callable<Map<String, String>> callable = new Callable<Map<String, String>>() {
			@Override
			public Map<String, String> call() throws Exception {
				return buildResult();
			}
		};

		doTask();

		WebAsyncTask<Map<String, String>> webAsyncTask = new WebAsyncTask<>(callable);

		System.out.println("r2 time consumption: " + ChronoUnit.SECONDS.between(now, Instant.now()) + " seconds");

		return webAsyncTask;

	}

	private Map<String, String> buildResult() {
		System.out.println("building result");
		Map<String, String> result = new HashMap<>();
		try {
			Thread.sleep(3 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 1 * 1000; i++) {
			result.put(i + "-key", i + "value");
		}
		return result;
	}

	private void doTask() {
		System.out.println("do some tasks");
		try {
			Thread.sleep(3 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
