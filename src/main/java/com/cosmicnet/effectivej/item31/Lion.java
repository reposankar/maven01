package com.cosmicnet.effectivej.item31;

public class Lion extends Feline{
	
	Lion (String name) {
		super(name);
	}
	
	@Override
	public void eat() {
		System.out.println("Lion : I eat Rats");
		
	}

	@Override
	public void sleep() {
		System.out.println("Lion : I sleep at nights");
		
	}

	@Override
	public void makeNoice() {
		System.out.println("Lion : Meowww...");
		
	}
	
	public void location() {
		System.out.println("Lion: I live in African Sarangeti");
	}
}
