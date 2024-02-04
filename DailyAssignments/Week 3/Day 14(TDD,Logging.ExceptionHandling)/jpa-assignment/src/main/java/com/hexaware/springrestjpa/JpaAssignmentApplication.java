package com.hexaware.springrestjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JpaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAssignmentApplication.class, args);
	}

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
