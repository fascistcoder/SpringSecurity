package com.example.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@ComponentScan("com.example")
@EnableJpaRepositories("com.example")
@EntityScan("com.example")
@EnableWebSecurity(debug = true)
public class SpringSecuritySection2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySection2Application.class, args);
	}

}
