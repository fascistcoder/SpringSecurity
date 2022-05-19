package com.example.oauth2demo.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
@RestController
public class SecureController {

	@GetMapping("/")
	public String main(OAuth2AuthenticationToken token){
		System.out.println(token.getPrincipal());
		return "secure.html";
	}
}
