package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	//비밀번호 암호화 : 1234 => 암호환된 값으로 인지
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean // 메모리상 인증 정보 등록 => 테스트 전용 방식
	InMemoryUserDetailsManager inMemoryUserDetailsService() {
		UserDetails user = User.builder()
							.username("user1")
							.password(passwordEncoder().encode("1234"))
							.roles("USER")
							.build();
		UserDetails admin = User.builder()
							.username("admin1")
							.password(passwordEncoder().encode("1234"))
							.authorities("ROLE_ADMIN")
							.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
}
