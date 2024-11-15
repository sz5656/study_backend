package com.yedam.app.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:springContext.xml");
		//file:src/main/resources/springContext.xml
		
		//TV tv = new TV();
		TV tv = (TV)ctx.getBean("tv");
		tv.turnON();
		
		TV subTV = (TV)ctx.getBean(TV.class);
		subTV.turnON();
		
		if(tv == subTV) System.out.println("동일객체");
		else System.out.println("다른객체");
		
	}
}
