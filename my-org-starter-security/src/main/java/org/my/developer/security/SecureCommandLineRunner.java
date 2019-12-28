package org.my.developer.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class SecureCommandLineRunner implements CommandLineRunner {

	private UserDetailsService userDetailsService;
	private GrantedAuthority requiredAuthority;
	private PasswordEncoder encoder;

	public SecureCommandLineRunner(UserDetailsService userDetailsService, GrantedAuthority requiredAuthority,
			PasswordEncoder encoder) {
		this.userDetailsService = userDetailsService;
		this.requiredAuthority = requiredAuthority;
		this.encoder = encoder;
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleCommandLinePropertySource loginInfo = new SimpleCommandLinePropertySource("loginSource", args);

		if (verifyLogin(loginInfo)) {
			secureRun(args);
		}
	}

	private boolean verifyLogin(SimpleCommandLinePropertySource loginInfo) {
		String userName = loginInfo.getProperty("username");
		String password = loginInfo.getProperty("password");

		if (userName == null || userName.isEmpty()) {
			System.out.println("Username missing!");
			return false;
		}

		if (password == null || password.isEmpty()) {
			System.out.println("Password missing!");
			return false;
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		if (userDetails != null) {
			if (encoder.matches(password, userDetails.getPassword())) {

				if (userDetails.getAuthorities().contains(requiredAuthority)) {
					return true;
				}
				System.out.println("User does not have required role.");
				return false;
			}
		}
		System.out.println("Username or password is incorrect!");
		return false;
	}

	public abstract void secureRun(String... args);
}
