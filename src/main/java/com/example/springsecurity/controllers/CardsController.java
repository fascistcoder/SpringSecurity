package com.example.springsecurity.controllers;

import com.example.springsecurity.model.Cards;
import com.example.springsecurity.model.Customer;
import com.example.springsecurity.repository.CardRepository;
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
public class CardsController {

	private final CardRepository cardRepository;

	@PostMapping("/myCards")
	public List<Cards> getCardsDetails(@RequestBody Customer customer) {
		List<Cards> cards = cardRepository.findByCustomerId(customer.getId());
		return !cards.isEmpty() ? cards : null;
	}
}
