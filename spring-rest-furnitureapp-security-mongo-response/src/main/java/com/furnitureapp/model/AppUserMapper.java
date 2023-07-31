package com.furnitureapp.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.Encoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
//@Component
public class AppUserMapper {
	@Autowired
	private PasswordEncoder encoder;
	public AppUser convertToAppUser(UserDetails user) {
        // get data from UserDetails
        String username = user.getUsername();
        String password = encoder.encode(user.getPassword());
        List<String>  roles = user.getAuthorities()
                            .stream()
                            .map(grantedAuthority->grantedAuthority.getAuthority())
                            .toList();
        // create appUser object
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(password);
        appUser.setRoles(roles);
        return appUser;
	}
	public UserDetails converToUserDetails(AppUser appUser) {
		String username = appUser.getUsername();
        String password = appUser.getPassword();
        List<GrantedAuthority>  roles = appUser.getRoles()
                .stream()
                .map(role->new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
        UserDetails user = new User(username,password,roles);
        return user;
	}
}
