package com.furnitureapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.furnitureapp.service.AppUserServiceImpl;
import com.furnitureapp.service.FurnitureServiceImpl;

//@Configuration
public class WebConfig {

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new AppUserServiceImpl();
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http.cors().and().csrf().disable().authorizeHttpRequests(
				httpRequest->{httpRequest.requestMatchers("/furniture-api").permitAll();
//				httpRequest.requestMatchers("/furniture-api/admin/**").hasRole("ADMIN");
//	            httpRequest.requestMatchers("/furniture-api/user/**").hasAnyRole("USER","ADMIN");
        })
        .httpBasic()
        .and()
        .build();	
	}
}
