package com.example.springsecurity.filter;

import com.example.springsecurity.constants.ApplicationConstants;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.springframework.http.HttpHeaders.*;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 16/05/22
 */
public class RequestValidationBeforeFilter implements Filter {

	private final Charset charset = StandardCharsets.UTF_8;

	@Override public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String header = request.getHeader(AUTHORIZATION);

		if (header != null) {
			header = header.trim();
			if (StringUtils.startsWithIgnoreCase(header, ApplicationConstants.AUTHENTICATION_SCHEME_BASIC)) {
				byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
				byte[] decoded;
				try {
					decoded = Base64.getDecoder().decode(base64Token);
					String token = new String(decoded, getCredentialsCharset(request));
					int delim = token.indexOf(":");
					if (delim == -1) {
						throw new BadCredentialsException("Invalid Basic Authentication");
					}
					String email = token.substring(0, delim);
					if (email.toLowerCase().contains("test")) {
						response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
						return;
					}
				} catch (IllegalArgumentException e) {
					throw new BadCredentialsException("Failed to decode basic authentication token");
				}
			}
		}
		filterChain.doFilter(request, response);
	}

	protected Charset getCredentialsCharset(HttpServletRequest request) {
		return getCredentialsCharset();
	}

	public Charset getCredentialsCharset() {
		return this.charset;
	}
}
