package com.example.resouceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScan("com.example")
@EnableJpaRepositories("com.example")
@EntityScan("com.example")
@EnableWebSecurity
public class ResouceserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResouceserverApplication.class, args);
	}

}
