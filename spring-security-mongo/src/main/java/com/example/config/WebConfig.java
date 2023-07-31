package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.service.AppUserServiceImpl;

@Configuration
public class WebConfig {
//	@Autowired
//	private AppUserServiceImpl appUserService;
	
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
				httpRequest->{httpRequest.requestMatchers("/greet-api/v1","/user-api/v1/app-users").permitAll();
				httpRequest.requestMatchers("/greet-api/v1/admin/**").hasRole("ADMIN");
	            httpRequest.requestMatchers("/greet-api/v1/user/**").hasAnyRole("USER","ADMIN");
        })
        .httpBasic()
        .and()
        .build();	
	}
	
}
