package com.gregs.mall.emall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.gregs.mall.emall.model.User;

@Service
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserEmail(String email);
}
