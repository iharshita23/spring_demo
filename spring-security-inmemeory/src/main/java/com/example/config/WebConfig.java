package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfig {
	@Bean
		public UserDetailsManager userDetailsManager() {
			UserDetails user1 =  User.withUsername("Harshi")
					.password(encoder().encode("harshi123"))
					.roles("ADMIN","USER")
					.build();
			
			UserDetails user2 =  User.withUsername("Harshita")
					.password(encoder().encode("harshita123"))
					.roles("ADMIN","USER")
					.build();
		
			return new InMemoryUserDetailsManager(user1,user2);
		}
	@Bean
		public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	    }
	@Bean
		public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		//authorize based on roles
		return http.authorizeHttpRequests(request->{
			request.requestMatchers("/").permitAll();
			request.requestMatchers("/user/**").hasAnyRole("ADMIN","USER");
			request.requestMatchers("/admin/**").hasRole("ADMIN");
		})
		.httpBasic()
		.and()
		.build();
	
	}
}
