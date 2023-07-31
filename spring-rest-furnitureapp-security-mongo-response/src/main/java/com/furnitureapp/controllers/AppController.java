package com.furnitureapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furnitureapp.model.AppUser;
import com.furnitureapp.model.AppUserMapper;

//@RestController
@RequestMapping("/app-api")
public class AppController {
//	Logger logger = LoggerFactory.getLogger(FurnitureController.class);
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	@Autowired
	private AppUserMapper appUserMapper;
	
//	public AppController(UserDetailsManager userDetailsManager) {
//		super();
//		this.userDetailsManager = userDetailsManager;
//	}
	@PostMapping("/app")
	public void addUser(@RequestBody AppUser appUser) {
		UserDetails user= appUserMapper.converToUserDetails(appUser);
		userDetailsManager.createUser(user);
	}
	@GetMapping("/app/username/{username}")
	public AppUser getUser(@PathVariable String username) {
		UserDetails user = userDetailsManager.loadUserByUsername(username);
		return appUserMapper.convertToAppUser(user);
	}
}
