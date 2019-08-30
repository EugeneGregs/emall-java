package com.gregs.mall.emall.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.gregs.mall.emall.model.Role;

@Service
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
