package com.ums.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginServiceApplication {

	public static void main(String[] args) {
		System.out.println("Before");
		SpringApplication.run(LoginServiceApplication.class, args);
		System.out.println("After");
	}

}
