package com.pankaj;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.pankaj.controller.MyController;

@SpringBootApplication()
@ComponentScan("com")
@EnableAsync
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	/*
	 * @Bean public OuterPackageBean getOuterPackageBean() { return new
	 * OuterPackageBean();
	 * 
	 * }
	 */
	@Bean(name = "asyncExecutor")
	public ThreadPoolTaskExecutor asyncExecutor() {
		
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(3);
		threadPoolTaskExecutor.setMaxPoolSize(3);
		threadPoolTaskExecutor.setQueueCapacity(100);
		threadPoolTaskExecutor.setThreadNamePrefix("AsyncThread-");
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}

	@Bean
	public List<String> nameList() {
		List<String> nameList = new ArrayList<>();
		nameList.add("Pankaj");
		nameList.add("Ashi");
		nameList.add("Ansh");
		nameList.add("Sachin");
		nameList.add("Priyanka");
		return nameList;
	}

	@Bean
	public List<String> nameListMembers() {
		List<String> nameList = new ArrayList<>();
		nameList.add("Pankaj1");
		nameList.add("Ashi1");
		nameList.add("Ansh");
		nameList.add("Sachin");
		nameList.add("Priyanka");
		
	
		
		return nameList;
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
