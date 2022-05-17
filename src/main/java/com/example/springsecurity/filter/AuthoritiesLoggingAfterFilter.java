package com.example.springsecurity.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 16/05/22
 */
@Slf4j
public class AuthoritiesLoggingAfterFilter implements Filter {

	@Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null != authentication) {
			log.info("User " + authentication.getName() + " is successfully authenticated and has the authorities "
					+ authentication.getAuthorities().toString());

		}

		filterChain.doFilter(servletRequest, servletResponse);
	}
}
