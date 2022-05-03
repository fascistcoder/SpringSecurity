package com.example.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="pulkit.aggarwal">Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/05/22
 */
@RestController
public class NoticesController {

	@GetMapping("/notices")
	public String getBalanceDetails(String input) {
		return "Here are the Notices details from the DB";
	}
}
