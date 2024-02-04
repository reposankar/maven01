package com.cosmicnet.patterns.structural.composite;



public class ExpressionComposite implements Expression{
	
	private Expression leftOperand, rightOperand;
	private final char operation;
	
	 
	ExpressionComposite(Expression leftOperand, char operation, Expression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
		this.operation = operation;
	}

	@Override
	public int evaluate() {
		int result = 0;
		
		switch(operation) {
			case '+' : 
				result = leftOperand.evaluate() + rightOperand.evaluate();
				break;
			case '-' : 
				result = leftOperand.evaluate() - rightOperand.evaluate();
				break;
			case '*' : 
				result = leftOperand.evaluate() * rightOperand.evaluate();
				break;
			case '/' : 
				result = leftOperand.evaluate() / rightOperand.evaluate();
				break;
			default: 
				throw new UnsupportedOperationException();
					
		}
		return result;
	}

}
