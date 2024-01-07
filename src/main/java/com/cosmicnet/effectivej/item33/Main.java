package com.cosmicnet.effectivej.item33;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Favorite f = new Favorite();
		
		String[] strings = {"Hi", "Hello", "How", "are", "you", "??"};
		f.putFavorite(String[].class, strings);
		
		Integer[] ints = {1, 5, 6, 23, 109};
		f.putFavorite(Integer[].class, ints);
		
		
		for(Integer s: f.getFavorite(Integer[].class)) {
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s: f.getFavorite(String[].class)) {
			System.out.print(s+" ");
		}
	}
	

}
