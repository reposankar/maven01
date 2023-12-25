package com.cosmicnet.patterns.singleton;

public class EnumDemo {
	
	public static void main(String[] args) {
		
		System.out.println("---First Line");
		Class<?> enumClass = SingletonEnum.class;
		System.out.println("--------Second Line");
		SingletonEnum red = SingletonEnum.RED;
		System.out.println("--------------Third Line");
		System.out.println("-------------------Forth Line");
		red.setName("Red Color");
		System.out.println("Red : "+red.getName());
		red = SingletonEnum.BLUE;
		System.out.println("Blue : "+red.getName());
		System.out.println("Color : "+SingletonEnum.RED.getName());
	}
	

}
