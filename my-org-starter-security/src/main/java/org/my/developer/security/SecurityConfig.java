package org.my.developer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return  PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService users(PasswordEncoder encoder) {
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		UserDetails admin = users.username("user").password("password").roles("USER").build();
		UserDetails user = users.username("admin").password("password").roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
}
	