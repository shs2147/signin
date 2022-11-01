package com.example.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.signup.entity.Role;
@EnableJpaRepositories
public interface RoleRepo extends JpaRepository<Role, Integer>{
	Role findByName(String name);
}
