package com.yedam.app.di;

public class JavaExample {

	public static void main(String[] args) {
		Chef chef = new Chef();
		Restaurant res = new Restaurant();
		res.setChef(chef);
		res.run();
	}

}
