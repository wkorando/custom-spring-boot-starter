package org.my.developer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties({WebSecurityConfigurer.class})
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private WebSecurityConfigurer webSecurityConfigurer;
	
	@Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .authorizeRequests()
          .antMatchers(webSecurityConfigurer.getAdminEndpoints()).hasRole("ADMIN")
          .antMatchers(webSecurityConfigurer.getUserEndpoints()).hasRole("USER")
          .antMatchers(webSecurityConfigurer.getUnsecuredEndpoints()).permitAll()
          .antMatchers("/login*").permitAll()
          .anyRequest().authenticated()
          .and()
          .formLogin();
    }

}
