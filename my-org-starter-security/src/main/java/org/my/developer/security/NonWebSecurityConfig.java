package org.my.developer.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
@EnableConfigurationProperties({ CommandLineSecurityConfigurer.class })
@ConditionalOnNotWebApplication
public class NonWebSecurityConfig {

	@Bean
	public GrantedAuthority createGrantedAuthority(CommandLineSecurityConfigurer cliSecurityConfigurer) {
		return new SimpleGrantedAuthority("ROLE_" + cliSecurityConfigurer.getRequiredRole());
	}
}
