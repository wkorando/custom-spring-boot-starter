package com.ibm.developer.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnNotWebApplication
public class NonWebSecurityConfig {


}
