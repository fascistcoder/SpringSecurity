package com.example.springsecurity.service.impl;

import com.example.springsecurity.model.Authority;
import com.example.springsecurity.model.Customer;
import com.example.springsecurity.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 07/05/22
 */
@Component
@AllArgsConstructor
public class InfiniteBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

	private final CustomerRepository customerRepository;

	private final PasswordEncoder passwordEncoder;

	@Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		List<Customer> customers = customerRepository.findByEmail(userName);
		if (customers.size() > 0) {
			if (passwordEncoder.matches(pwd, customers.get(0).getPwd())) {
				return new UsernamePasswordAuthenticationToken(userName, pwd, getGrantedAuthorities(customers.get(0).getAuthorities()));
			} else {
				throw new BadCredentialsException("Invalid Password");
			}
		} else {
			throw new BadCredentialsException("No User is Registered");
		}
	}

	private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Authority authority : authorities){
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		return grantedAuthorities;
	}

	@Override public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
