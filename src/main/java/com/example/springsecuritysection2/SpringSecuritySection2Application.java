package com.example.springsecuritysection2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example")
@EnableJpaRepositories("com.example")
@EntityScan("com.example")
public class SpringSecuritySection2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySection2Application.class, args);
	}

}
