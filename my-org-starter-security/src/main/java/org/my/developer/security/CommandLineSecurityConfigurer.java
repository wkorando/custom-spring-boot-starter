package org.my.developer.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my-org.security.cli")
public class CommandLineSecurityConfigurer {

	/**
	 * A User's Role
	 */
	private String requiredRole;

	public String getRequiredRole() {
		return requiredRole;
	}

	public void setRequiredRole(String requiredRole) {
		this.requiredRole = requiredRole;
	}

}
