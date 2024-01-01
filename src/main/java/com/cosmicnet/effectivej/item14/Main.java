package com.cosmicnet.effectivej.item14;

import java.util.Arrays;
import java.util.List;
//import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;


public class Main {
	public static void main(String[] args) {
		PhoneNumber p1 = new PhoneNumber(23, 45, 103);
		PhoneNumber p2 = new PhoneNumber(91, 96496, 75373);
		PhoneNumber p3 = new PhoneNumber(1, 19, 6033);
		PhoneNumber p4 = new PhoneNumber(44, 85, 2384);
		PhoneNumber p5 = new PhoneNumber(5, 85, 527);
		List<PhoneNumber> pl = Arrays.asList(p1, p2, p3, p4, p5);
		System.out.println(pl);
		List<Integer> ph1 = Arrays.asList(p1.hashCode(), p2.hashCode(), p3.hashCode(), p4.hashCode(), p5.hashCode());
		System.out.println(ph1);
		PhoneNumber ph2 = p1.clone();
		System.out.println(ph2);
		Set<PhoneNumber> ps = new TreeSet<>();
		ps.addAll(pl);
		System.out.println(ps);
		
		
	}

}
