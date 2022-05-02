package com.example.springsecuritysection2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class SpringSecuritySection2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySection2Application.class, args);
	}

}
