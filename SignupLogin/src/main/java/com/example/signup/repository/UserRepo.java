package com.example.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.signup.entity.User;
@EnableJpaRepositories

public interface UserRepo extends JpaRepository<User, Integer> {

	 public User findByEmailId(String emailId);
     public User findOneByIgnoreCaseEmailIdAndPassword(String emailId, String password);
}
