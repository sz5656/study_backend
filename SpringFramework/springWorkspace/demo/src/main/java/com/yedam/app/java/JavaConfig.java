package com.yedam.app.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	// <bean/> => @Bean
	@Bean("tv")
	public TV createTV() {
		return new TV();
	}
}
