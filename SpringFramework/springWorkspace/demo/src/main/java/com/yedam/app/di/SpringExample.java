package com.yedam.app.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringExample {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Restaurant res = (Restaurant)ctx.getBean(Restaurant.class);
		res.run();
	}

}
