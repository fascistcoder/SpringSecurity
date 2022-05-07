package com.example.springsecurity.service.impl;

import com.example.springsecurity.model.Customer;
import com.example.springsecurity.model.InfiniteBankCustomer;
import com.example.springsecurity.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/05/22
 */
@AllArgsConstructor
@Service
public class InfiniteBankUserDetailServiceImpl implements UserDetailsService {

	private CustomerRepository customerRepository;

	@Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customer> customers = customerRepository.findByEmail(username);
		if (customers.size() == 0) {
			throw new UsernameNotFoundException("User Details Not found for the user : " + username);
		}
		return new InfiniteBankCustomer(customers.get(0));
	}
}
