package com.yedam.app.di;

import org.springframework.stereotype.Component;

@Component
public class Chef {
	public void cooking() {
		System.out.println("셰프가 요리중입니다.");
	}
}
