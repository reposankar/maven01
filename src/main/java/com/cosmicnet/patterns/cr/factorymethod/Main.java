package com.cosmicnet.patterns.cr.factorymethod;

public class Main {
	public static void main(String[] args) {
		//PizzaStore pStore = new NYPizzaStore();
		PizzaStore pStore = new ItalyPizzaStore();
		//pStore.orderPizza(PizzaType.CHEESE);
		pStore.orderPizza(PizzaType.PEPPARONI);
		
	}

}
