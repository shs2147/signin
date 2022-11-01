package com.example.signup.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private int id;
	@Column(nullable=false,unique=true )
	private String emailId;
	@Column(nullable = false,unique = true)
	private String password;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@ManyToMany(targetEntity=Role.class,cascade = {CascadeType.ALL})
	@JoinTable(name="user_role",
			joinColumns = 
			@JoinColumn(name="userId",referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="roleId", referencedColumnName="id"))
		private List<Role>roles;
		
}
