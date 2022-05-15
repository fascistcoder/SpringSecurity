package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

/**
 * @author <a href="pulkit.aggarwal">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/05/22
 */
@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override protected void configure(HttpSecurity http) throws Exception {

		// Default configurations which will secure all the requests
		//	http.authorizeRequests()
		// 		.anyRequest().authenticated()
		// 		.and()
		// 		.formLogin().and()
		// 		.httpBasic();

		// Custom configurations as per our requirement
		http.cors().configurationSource(new CorsConfigurationSource() {
					@Override public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						CorsConfiguration configuration = new CorsConfiguration();
						configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
						configuration.setAllowedMethods(Collections.singletonList("*"));
						configuration.setAllowCredentials(true);
						configuration.setAllowedHeaders(Collections.singletonList("*"));
						configuration.setMaxAge(3600L);
						return configuration;
					}
				}).and()
				.csrf().ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and().
				authorizeRequests()
				.antMatchers("/myAccount").authenticated()
				.antMatchers("/myCards").authenticated()
				.antMatchers("/myBalance").authenticated()
				.antMatchers("/myLoans").authenticated()
				.antMatchers("/notices").permitAll()
				.antMatchers("/contact").permitAll()
				.and()
				.formLogin().and()
				.httpBasic();

		// Configuration to deny all the requests
		//	http.authorizeRequests()
		// 		.anyRequest().denyAll()
		// 		.and()
		// 		.formLogin().and()
		// 		.httpBasic();

		// Configuration to permit all the requests
		//		http.authorizeRequests()
		//				.anyRequest().permitAll()
		//				.and()
		//				.formLogin().and()
		//				 		.httpBasic();

	}

/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("12345").authorities("admin").and()
				.withUser("user").password("12345").authorities("read").and()
				.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
*/
	//
	//	@Override
	//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
	//		UserDetails userDetails = User.withUsername("admin").password("12345").authorities("admin").build();
	//		UserDetails userDetails1 = User.withUsername("user").password("12345").authorities("read").build();
	//		userDetailsManager.createUser(userDetails);
	//		userDetailsManager.createUser(userDetails1);
	//		auth.userDetailsService(userDetailsManager);
	//	}

	//	@Bean
	//	public UserDetailsService userDetailsService(DataSource dataSource){
	//		return new JdbcUserDetailsManager(dataSource);
	//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
