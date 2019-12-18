package com.ibm.developer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	public SecurityConfig() {
		System.out.println("IN SecurityConfig");
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails admin = User.withUsername("user").password("password").roles("USER").build();
		UserDetails user = User.withUsername("admin").password("password").roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
}
