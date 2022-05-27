package com.example.resouceserver.controller;

import com.example.resouceserver.model.AccountsTransaction;
import com.example.resouceserver.model.Customer;
import com.example.resouceserver.reposiorty.AccountTransactionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="pulkit.aggarwal">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/05/22
 */
@RestController
@AllArgsConstructor
public class BalanceController {

	private final AccountTransactionsRepository accountTransactionsRepository;

	@PostMapping("/myBalance")
	public List<AccountsTransaction> getBalanceDetails(@RequestBody Customer customer) {
		return accountTransactionsRepository.findAccountsTransactionByCustomerIdOrderByTransactionDateDesc(
				customer.getId());
	}
}
