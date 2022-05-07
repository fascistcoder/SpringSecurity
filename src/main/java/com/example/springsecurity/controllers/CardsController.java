package com.example.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="pulkit.aggarwal">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/05/22
 */
@RestController
public class CardsController {
	@GetMapping("/myCards")
	public String getBalanceDetails(String input) {
		return "Here are the card details from the DB";
	}
}