package com.gregs.mall.emall.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gregs.mall.emall.model.LoginViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authManager;
	
	public JwtAuthenticationFilter(AuthenticationManager authManager) {
		this.authManager = authManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		// Map request to LoginViewModel
		
		LoginViewModel credentials = null;
		
		try {
			credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//Create Authentication token
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				credentials.getUserName(),
				credentials.getPassword(),
				new ArrayList<>());
		
		//Use the authentication token to authenticate the user
		Authentication auth = authManager.authenticate(token);
		
		//Return the authentication
		return auth;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		//grab principal
		
		UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();
		
		//create jwt
			String token = JWT
					.create()
					.withSubject(principal.getUsername())
					.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME *1000))
					.sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));
		
		
		//add jwt to header
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(
	            "{\"" + SecurityConstants.HEADER_STRING + "\":\"" + SecurityConstants.TOKEN_PREFIX+token + "\"}"
	    );
	}
}
