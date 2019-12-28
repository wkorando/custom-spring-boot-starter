package org.my.developer.myconsoleapp;

import org.my.developer.security.SecureCommandLineRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecureCommandLineRunnerImpl extends SecureCommandLineRunner {

	public SecureCommandLineRunnerImpl(UserDetailsService userDetailsService, GrantedAuthority requiredAuthority,
			PasswordEncoder encoder) {
		super(userDetailsService, requiredAuthority, encoder);
	}

	@Override
	public void secureRun(String... args) {
		System.out.println("EXECUTING VIRUS");
	}

}
