package com.cosmicnet.patterns.cr.factorymethod;

public class ItalyCheesePizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("Preparing Italy Cheese Pizza");
		
	}

	@Override
	public void bake() {
		System.out.println("Baking Italy Cheese Pizza");
		
	}

	@Override
	public void cut() {
		System.out.println("Cutting Italy Cheese Pizza");
		
	}

	@Override
	public void pack() {
		System.out.println("Packing Italy Cheese Pizza");
		
	}

}
