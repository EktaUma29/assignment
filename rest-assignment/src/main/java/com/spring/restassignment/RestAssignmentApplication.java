package com.spring.restassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RestAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestAssignmentApplication.class, args);
	}

}
