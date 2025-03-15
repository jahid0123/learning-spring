package com.jmjbrothers.first_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstSpringApplication.class, args);
	}
}
