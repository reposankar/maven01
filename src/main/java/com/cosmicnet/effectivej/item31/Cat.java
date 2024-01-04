package com.cosmicnet.effectivej.item31;

import java.util.Objects;

public class Cat extends Feline{
	
	Cat(String name) {
		super(name);
	}
	
	@Override
	public void eat() {
		System.out.println("Cat : I eat Rats");
		
	}

	@Override
	public void sleep() {
		System.out.println("Cat : I sleep at nights");
		
	}

	@Override
	public void makeNoice() {
		System.out.println("Cat : Meowww...");
		
	}
	
	public void petName() {
		System.out.println("My pet name is Cathy Cat");
	}
	


}
