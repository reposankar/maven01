package com.cosmicnet.patterns.be.iterator;

import java.util.Map;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		MyHashMap<String, String> myMap = new MyHashMap<>();
		myMap.put("Chicken Soup", "Appetizer");
		myMap.put("Chow Chow Soup", "Appetizer");
		myMap.put("Spring Rolls", "Starter");
		myMap.put("Chicken 65", "Starter");
		myMap.put("Chicken Verval", "Main");
		myMap.put("Indian Bread - Naan", "Main");
		myMap.put("Indian Bread - Roti", "Main");
		myMap.put("Rice", "Main");
		myMap.put("Spicy Mutton Curry", "Main");
		myMap.put("Venilla Icec Cream", "Dessert");
		
		
		
		System.out.println(myMap);
		
		//System.out.println("Chicken Verval : "+hotelMenu.get("Chicken Verval"));
		System.out.println("------------------------------------");
		
		Iterator<Map.Entry<String,String>>  it = myMap.entrySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		/*
		System.out.println("------------------------------------");
		for(Iterator<String> i = myMap.keySet().iterator(); i.hasNext();) 
			System.out.println(i.next());
		*/
		System.out.println("------------------------------------");
		for(Iterator<String> i = myMap.iterator(); i.hasNext();) 
			System.out.println(i.next());
		
	}

}
