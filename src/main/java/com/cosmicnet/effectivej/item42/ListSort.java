package com.cosmicnet.effectivej.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {
	public static void main(String[] args) {
		
		List<String> l1 = List.of("Hi", "How", "are", "u");
		//Arrays.asList("Hi", "How", "are", "u");
		System.out.println(l1);
		List<String> l2 = Arrays.asList(new String[] {"Hi", "How", "are", "u"});
//		Collections.sort(l2, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				return Integer.compare(s1.length(), s2.length());
//			}
//		});
		//Collections.sort(l2, (x,y)->Integer.compare(x.length(), y.length()));
		//Collections.sort(l2, Comparator.comparingInt(x->x.length()));
		//Collections.sort(l2, Comparator.comparingInt(String::length));
		l2.sort(Comparator.comparingInt(String::length));
		System.out.println(l2);

		
		
	}

}
