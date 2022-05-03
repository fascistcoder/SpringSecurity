package com.example.springsecuritysection2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="pulkit.aggarwal">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/05/22
 */
@RestController
public class BalanceController {
	@GetMapping("/myBalance")
	public String getBalanceDetails(String input) {
		return "Here are the balance details from the DB";
	}
}
