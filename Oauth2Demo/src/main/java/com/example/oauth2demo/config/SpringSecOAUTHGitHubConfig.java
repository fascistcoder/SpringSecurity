package com.example.oauth2demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
@Configuration
public class SpringSecOAUTHGitHubConfig extends WebSecurityConfigurerAdapter {

	//	private ClientRegistration clientRegistration() {
	//		return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("405bc5b0c9c26e869817")
	//				.clientSecret("fd2b9acd4ff011b2eb5c5b8806960e64713f77eb").build();
	//	}

	@Override protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().oauth2Login();
	}

	//
	//	@Bean
	//	public ClientRegistrationRepository clientRegistrationRepository(){
	//		ClientRegistration clientRegistration = clientRegistration();
	//		return new InMemoryClientRegistrationRepository(clientRegistration);
	//	}

	/*
	 * private ClientRegistration clientRegistration() { ClientRegistration cr =
	 * ClientRegistration.withRegistrationId("github").clientId(
	 * "3c9be97074f067e78e75")
	 * .clientSecret("ab313f7ade3d79e06c192ca80cf152c43cb5d916").scope(new String[]
	 * { "read:user" })
	 * .authorizationUri("https://github.com/login/oauth/authorize")
	 * .tokenUri("https://github.com/login/oauth/access_token").userInfoUri(
	 * "https://api.github.com/user")
	 * .userNameAttributeName("id").clientName("GitHub")
	 * .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
	 * .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}").build
	 * (); return cr; }
	 */
}
