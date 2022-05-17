package com.example.springsecurity.filter;

import lombok.extern.slf4j.Slf4j;

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
public class AuthoritiesLoggingAtFilter implements Filter {
	@Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		log.info("Authentication Validation is in Progress");
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
