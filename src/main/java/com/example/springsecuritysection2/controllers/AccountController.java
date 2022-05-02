package com.example.springsecuritysection2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="pulkit.aggarwal@upgrad.com">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/05/22
 */
@RestController
public class AccountController {
	@GetMapping
	public String getAccountDetails(String input) {
		return "Here are the account details from the DB";
	}
}
