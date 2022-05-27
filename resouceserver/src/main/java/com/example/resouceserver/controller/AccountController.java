package com.example.resouceserver.controller;


import com.example.resouceserver.model.Accounts;
import com.example.resouceserver.model.Customer;
import com.example.resouceserver.reposiorty.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="pulkit.aggarwal">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/05/22
 */
@RestController
@AllArgsConstructor
public class AccountController {

	private AccountRepository accountsRepository;

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		Accounts accounts = accountsRepository.findByCustomerId(customer.getId());
		return StringUtils.hasText(accounts.toString()) ? accounts : null;
	}
}
