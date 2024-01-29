package com.cosmicnet.patterns.cr.factorymethod;

public class ItalyPepparoniPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("Preparing Italy Pepparoni Pizza");
		
	}

	@Override
	public void bake() {
		System.out.println("Baking Italy Pepparoni Pizza");
		
	}

	@Override
	public void cut() {
		System.out.println("Cutting Italy Pepparoni Pizza");
		
	}

	@Override
	public void pack() {
		System.out.println("Packing Italy Pepparoni Pizza");
		
	}

}
