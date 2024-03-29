package com.chrisb.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ReactTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactTestApplication.class, args);
	}

	
//	API tool
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
