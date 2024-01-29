package com.cosmicnet.patterns.cr.factorymethod;

public class NYPizzaStore extends PizzaStore{

	@Override
	protected Pizza createPizza(PizzaType type) {
		switch(type) {
		case PEPPARONI : 
			return new NYPepparoniPizza();
		case CHEESE:
			return new NYCheesePizza();
		default:
			throw new IllegalArgumentException("Invalid argument "+type);
		}
		
	}

}
