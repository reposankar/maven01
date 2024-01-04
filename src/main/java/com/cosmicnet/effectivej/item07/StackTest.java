package com.cosmicnet.effectivej.item07;

import java.util.Iterator;

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
		//System.out.println(es.pop());
		es.pop();
		es.push(e1);
		es.push(e2);
		System.out.println(es.pop());
		System.out.println(es.pop());
		System.out.println(es.pop());
		System.out.println(es.pop());
		System.out.println(es.pop());
		//System.out.println(es.pop());

		for (int i = 0; i < 120; i++) {
			es.push(new Emp("x "+i));
		}

		for (Iterator<Emp> i = es.iterator(); i.hasNext();) {
			System.out.println(i.next());
		}
		es.push(e4);
		es.push(e3);
		System.out.println(es.pop());
		 
	}

}
