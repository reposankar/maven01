package com.cosmicnet.patterns.structural.composite;

public class Operand implements Expression{
	
	private int value;
	
	Operand(int value) {
		this.value = value;
	}

	@Override
	public int evaluate() {
		return value;
	}

}
