package com.pankaj.service;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {
	private String name;

	public CallableTask(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.println("task execution start...");
		int waitSeconds = 2;
		if ("timeout".equals(name)) {
			waitSeconds = 5;
		}
		Thread.sleep(waitSeconds * 1000);
		if ("error".equals(name)) {
			throw new RuntimeException("Manual exception at runtime");
		}
		System.out.println("task execution end...");
		return "Welcome " + name + "!";
	}

}
