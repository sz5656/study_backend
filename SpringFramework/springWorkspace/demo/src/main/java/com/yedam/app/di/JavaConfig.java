package com.yedam.app.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	@Bean
	public Chef createChef() {
		return new Chef();
	}
	
	@Bean
	public Restaurant createRestaurant(Chef chef) {
		//return new Restaurant(chef);
		Restaurant res = new Restaurant();
		res.setChef(chef);
		return res;
	}
}
