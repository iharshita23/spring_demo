package com.furnitureapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.furnitureapp.model.AppUser;
import com.furnitureapp.model.AppUserMapper;
import com.furnitureapp.model.Furniture;
import com.furnitureapp.model.FurnitureMapper;
import com.furnitureapp.repository.IAppUserRepository;

//@Service
public class AppUserServiceImpl implements UserDetailsManager{

	@Autowired 
	private IAppUserRepository iappuserRepository;
	@Autowired
	private AppUserMapper appUserMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// from  backend database to controller-> frontend
        AppUser appUser = iappuserRepository.findByUsername(username);
        // convert to userdetails object
        UserDetails user = appUserMapper.converToUserDetails(appUser);
        return user;
	}

	@Override
	public void createUser(UserDetails user) {
		String username = user.getUsername();
		String password = user.getPassword();
		List<String> roles = user.getAuthorities()
				.stream()
				.map(grantedAuthority->grantedAuthority.getAuthority())
				.toList();
		//create AppUser object
		AppUser appUser = new AppUser();
		appUser.setUsername(username);
		appUser.setPassword(password);
		appUser.setRoles(roles);
		//save in repository
		iappuserRepository.insert(appUser);
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
