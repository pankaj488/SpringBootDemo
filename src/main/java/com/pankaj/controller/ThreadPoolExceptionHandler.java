package com.pankaj.controller;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class ThreadPoolExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... params) {
		System.out.println( "%%%%%%%%%%%%%%%%%%%%%% :: "+ex.getLocalizedMessage());
		
	}

}
