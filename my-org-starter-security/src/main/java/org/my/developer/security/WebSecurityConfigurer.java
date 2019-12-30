package org.my.developer.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my-org.web.security")
public class WebSecurityConfigurer {

	/**
	 * Endpoints that require the USER role to access
	 */
	private String[] userEndpoints = new String[] {};
	/**
	 * Endpoints that require the ADMIN role to access
	 */
	private String[] adminEndpoints = new String[] {};
	/**
	 * Endpoints that have no security requirements.
	 *
	 * Default value: /public**
	 */
	private String[] unsecuredEndpoints = new String[] {"/public**"};

	public String[] getUserEndpoints() {
		return userEndpoints;
	}

	public void setUserEndpoints(String[] userEndpoints) {
		this.userEndpoints = userEndpoints;
	}

	public String[] getAdminEndpoints() {
		return adminEndpoints;
	}

	public void setAdminEndpoints(String[] adminEndpoints) {
		this.adminEndpoints = adminEndpoints;
	}

	public String[] getUnsecuredEndpoints() {
		return unsecuredEndpoints;
	}

	public void setUnsecuredEndpoints(String[] unsecuredEndpoints) {
		this.unsecuredEndpoints = unsecuredEndpoints;
	}

}
