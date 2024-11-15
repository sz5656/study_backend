package com.yedam.app.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Restaurant {
	
	private Chef chef;
	
	//생성자 주입
//	@Autowired
	public Restaurant(Chef chef) {
		System.out.println("생성자 주입");
		this.chef = chef;
	}
	//세터 주입
	public Restaurant() {}
//	@Autowired
	public void setChef(Chef chef) {
		System.out.println("세터 주입");
		this.chef = chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
