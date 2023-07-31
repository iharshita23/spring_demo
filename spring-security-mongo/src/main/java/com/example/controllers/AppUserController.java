package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AppUser;
import com.example.model.AppUserMapper;

@RestController
@RequestMapping("/user-api/v1")
public class AppUserController {
	
	private UserDetailsManager userDetailsManager;
	@Autowired
	private AppUserMapper appUserMapper;
	
		public AppUserController(UserDetailsManager userDetailsManager) {
		super();
		this.userDetailsManager = userDetailsManager;
	}

		@PostMapping("/app-users")
		public void addAppUser(@RequestBody AppUser appUser) {
			UserDetails user= appUserMapper.converToUserDetails(appUser);
			userDetailsManager.createUser(user);
		}
		@GetMapping("/app-users/username/{username}")
		public AppUser getAppUser(@PathVariable String username) {
			return null;
		}
		
	
}
