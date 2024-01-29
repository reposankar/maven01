package com.cosmicnet.patterns.cr.factorymethod;

public class ItalyPizzaStore extends PizzaStore{

	@Override
	protected Pizza createPizza(PizzaType type) {
		switch(type) {
		case PEPPARONI : 
			return new ItalyPepparoniPizza();
		case CHEESE:
			return new ItalyCheesePizza();
		default:
			throw new IllegalArgumentException("Invalid argument "+type);
		}
		
	}

}
