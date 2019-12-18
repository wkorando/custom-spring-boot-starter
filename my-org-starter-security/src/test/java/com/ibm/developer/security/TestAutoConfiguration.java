package com.ibm.developer.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

public class TestAutoConfiguration {
	@Test
	public void autoConfigTest() {
	    ConditionEvaluationReportLoggingListener initializer = new ConditionEvaluationReportLoggingListener(
	            LogLevel.INFO);
	    ApplicationContextRunner contextRunner = new ApplicationContextRunner()
	            .withInitializer(initializer).run((context) -> {
	                    // Do something...
	            });
	}
}
