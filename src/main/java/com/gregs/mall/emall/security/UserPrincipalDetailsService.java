package com.gregs.mall.emall.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gregs.mall.emall.model.User;
import com.gregs.mall.emall.dao.UserRepository;
import com.gregs.mall.emall.exception.ResourceNotFoundException;

@Service
public class UserPrincipalDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserEmail(username);
		
		if(user == null ) throw new ResourceNotFoundException("User with email " + username + " does not exist");
		
		UserPrincipal userPrincipal = new UserPrincipal(user);
		return userPrincipal;
	}

}
