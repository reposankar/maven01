package com.cosmicnet.patterns.cr.factorymethod;

public abstract class PizzaStore {
	public Pizza orderPizza(PizzaType type) {
		Pizza p = createPizza(type);
		p.prepare();
		p.bake();
		p.cut();
		p.pack();
		return p;
	}
	
	protected abstract Pizza createPizza(PizzaType type);

}
