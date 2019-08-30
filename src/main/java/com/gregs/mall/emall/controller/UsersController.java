package com.gregs.mall.emall.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregs.mall.emall.dao.RoleRepository;
import com.gregs.mall.emall.dao.UserRepository;
import com.gregs.mall.emall.model.Role;
import com.gregs.mall.emall.model.User;

@RestController
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/users")
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/roles")
	public List<Role> allRoles(){
		return roleRepository.findAll();
	}
	
	@GetMapping("/admins")
	public List<User> allCustomers(){
		List<Role> roles = roleRepository.findAll();
		List<User> adminsList = new ArrayList<User>();
		
		roles.forEach(r -> {
			if( r.getId() == 2 ) {
				adminsList.addAll(r.getUsers());
			}
		});
		
		return adminsList;
	}
}
