package com.furnitureapp.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="appuser")
public class AppUser {
	@Indexed(unique=true)
	private String username;
	private String password;
	private String email;
	private List<String>roles; 
	@Id
	private String userId;
	
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public AppUser(String username, String password, String email, String userId, List<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.userId = userId;
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "AppUser [username=" + username + ", password=" + password + ", email=" + email + ", roles=" + roles
				+ ", userId=" + userId + "]";
	}
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
