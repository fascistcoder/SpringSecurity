package com.example.resouceserver.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 27/05/22
 */
public class KeyCloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override public Collection<GrantedAuthority> convert(Jwt jwt) {

		Map<String, Object> relamAccess = (Map<String, Object>) jwt.getClaims().get("relam_access");

		if(relamAccess == null || relamAccess.isEmpty()){
			return new ArrayList<>();
		}

		return ((List<String>) relamAccess.get("roles"))
				.stream().map(roleName -> "ROLE_" + roleName)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
}
