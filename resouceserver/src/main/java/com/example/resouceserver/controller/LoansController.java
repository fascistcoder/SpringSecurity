package com.example.resouceserver.controller;


import com.example.resouceserver.model.Customer;
import com.example.resouceserver.model.Loans;
import com.example.resouceserver.reposiorty.LoanRepository;
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
public class LoansController {
	private LoanRepository loanRepository;

	@PostMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer) {
		List<Loans> loans = loanRepository.findByEmailOrderByStartDateDesc(customer.getEmail());
		return !loans.isEmpty() ? loans : null;
	}
}
