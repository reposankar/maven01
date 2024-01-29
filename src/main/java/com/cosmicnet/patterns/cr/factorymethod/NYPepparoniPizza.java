package com.cosmicnet.patterns.cr.factorymethod;

public class NYPepparoniPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("Preparing NY Pepparoni Pizza");
		
	}

	@Override
	public void bake() {
		System.out.println("Baking NY Pepparoni Pizza");
		
	}

	@Override
	public void cut() {
		System.out.println("Cutting NY Pepparoni Pizza");
		
	}

	@Override
	public void pack() {
		System.out.println("Packing NY Pepparoni Pizza");
		
	}

}
