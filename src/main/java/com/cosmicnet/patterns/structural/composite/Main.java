package com.cosmicnet.patterns.structural.composite;

import java.math.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Expression op1 = new Operand(5);
		Expression op2 = new Operand(3);
		Expression ec1 = new ExpressionComposite(op1, '*', op2);
		System.out.println("ec1 : "+ec1.evaluate());
		Expression ec2 = new ExpressionComposite(ec1, '-', op2);
		System.out.println("ec2 : "+new ExpressionComposite(ec2, '/', ec1).evaluate());
		IntStream.range(2, 4).boxed().forEach(System.out::println);
	}

}
