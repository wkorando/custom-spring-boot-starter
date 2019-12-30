package org.my.developer.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("my-org.cli.security")
public class CommandLineSecurityConfigurer {

	/**
	 * The role a user must have to run the application.
	 */
	private String requiredRole;

	public String getRequiredRole() {
		return requiredRole;
	}

	public void setRequiredRole(String requiredRole) {
		this.requiredRole = requiredRole;
	}

}
