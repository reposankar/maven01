package com.cosmicnet.effectivej.item07;

public class StackTest {
	public static void main(String[] args) {
		Stack<Emp> es = new Stack<>();
		//Emp e = es.pop();
		//System.out.println(e);
		Emp e1 = new Emp("john Caramine");
		Emp e2 = new Emp("Rodgy Belton");
		Emp e3 = new Emp("Mime Koury");
		Emp e4 = new Emp("Navasky Chandler");
		es.push(e1);
		es.push(e2);
		es.push(e4);
		es.push(e3);
		System.out.println(es.pop());
		es.push(e1);
		es.push(e2);
		System.out.println(es.pop());
		System.out.println(es.pop());
		System.out.println(es.pop());
		System.out.println(es.pop());
		System.out.println(es.pop());
		//System.out.println(es.pop());
		 
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			es.push(new Emp("x "+i));
		}
		 
	}

}
