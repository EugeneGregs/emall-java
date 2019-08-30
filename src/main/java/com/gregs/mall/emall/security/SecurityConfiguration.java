package com.gregs.mall.emall.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.gregs.mall.emall.dao.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserPrincipalDetailsService userPrincipalDetails;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(daoProvider());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(new JwtAuthenticationFilter(authenticationManager()))
			.addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userRepository))
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/api/users").hasAuthority("ADMIN")
			.antMatchers("/api/products/*").hasAnyAuthority("ADMIN", "SELLER")
			.and()
			.httpBasic();
	}
	
	@Bean
	DaoAuthenticationProvider daoProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userPrincipalDetails);
		
		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CorsFilter corsFilter() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
	config.setAllowCredentials(true);
	config.addAllowedOrigin("*");
	config.addAllowedHeader("*");
	config.addAllowedMethod("OPTIONS");
	config.addAllowedMethod("GET");
	config.addAllowedMethod("POST");
	config.addAllowedMethod("PUT");
	config.addAllowedMethod("DELETE");
	source.registerCorsConfiguration("/**", config);
	return new CorsFilter(source);
	}
}
