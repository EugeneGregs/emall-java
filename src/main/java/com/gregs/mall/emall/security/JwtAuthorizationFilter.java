package com.gregs.mall.emall.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.gregs.mall.emall.model.User;
import com.gregs.mall.emall.dao.UserRepository;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter{
	private UserRepository userRepository;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepo) {
		super(authenticationManager);
		this.userRepository = userRepo;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//grab the header
		String header = request.getHeader(SecurityConstants.HEADER_STRING);
		
		//check if header has bearer
		if(header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		
		Authentication authentication = getUsernamePasswordAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		chain.doFilter(request, response);
	}

	private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
		
		//Get jwt token
		String token = request.getHeader(SecurityConstants.HEADER_STRING);
		
		if(token != null) {
			
		
			try {
				
				//Decode the token and grab username
				
				String userEmailString = JWT
						.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
						.build()
						.verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
						.getSubject();
				
				//If user name exists, use it to generate authentication
				if( userEmailString != null ) {
					User user = userRepository.findByUserEmail(userEmailString);
					UserPrincipal principal = new UserPrincipal(user);
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
							userEmailString,
							null,
							principal.getAuthorities());
					return auth;
				}
				return null;
			}
			catch (TokenExpiredException e) {
				request.setAttribute("expired",e.getMessage());
				return null;
			}	
			
		}
		
		return null;
	}

}
