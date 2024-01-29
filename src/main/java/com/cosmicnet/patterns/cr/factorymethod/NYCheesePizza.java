package com.cosmicnet.patterns.cr.factorymethod;

public class NYCheesePizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("Preparing NY Cheese Pizza");
		
	}

	@Override
	public void bake() {
		System.out.println("Baking NY Cheese Pizza");
		
	}

	@Override
	public void cut() {
		System.out.println("Cutting NY Cheese Pizza");
		
	}

	@Override
	public void pack() {
		System.out.println("Packing NY Cheese Pizza");
		
	}

}
