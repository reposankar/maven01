package com.cosmicnet.patterns.singleton;



class App {
	public static void main(String[] args) {
		AppConfig ac = AppConfig.getInstance();
		System.out.println(ac);
		//AppConfig ac1 = new AppConfig();
		//System.out.println(ac1);
		AppConfig ac2 = AppConfig.getInstance();
		System.out.println(ac2);
	}
}