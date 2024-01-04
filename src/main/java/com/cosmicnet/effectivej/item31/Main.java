package com.cosmicnet.effectivej.item31;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.ArrayList;


/**
 * 
 * @author Sankar M
 * @apiNote Implemented wildcard recursive generics.
 * Assume the return class T is Feline, the Comparable 
 * in interface is used in its super class Animal and 
 * this we have "? super T" in the Comparable generic. 
 * Whereas, parameter can be any subclass of Feline 
 * and hence we have "? extends T" in the max method 
 * List parameter.  
 *
 */
public class Main {
	
	public static <T extends Comparable<? super T>> T max (List<? extends T> list) {
		if (list.isEmpty())
			throw new InvalidParameterException();
		T result = null;
		for(T t:list) 
			if(result == null || t.compareTo(result) > 0)
				result = t;
		return result;
	}
	
	public static void main(String[] args) {
		
		List<Cat> listOfCats= new ArrayList<>();
		listOfCats.add(new Cat("Cat A"));
		listOfCats.add(new Cat("Cat b"));
		listOfCats.add(new Cat("Cat C"));
		listOfCats.add(new Cat("Cat d"));
		listOfCats.add(new Cat("Cat E"));
		listOfCats.add(new Cat("Cat E"));
		Cat max = max(listOfCats);
		System.out.println(max);
		System.out.println("-------------------------------");
		
		List<Feline> listOfFelines= new ArrayList<>();
		listOfFelines.add(new Cat("A Cat"));
		listOfFelines.add(new Cat("b Cat"));
		listOfFelines.add(new Cat("C Cat"));
		listOfFelines.add(new Lion("d Lion"));
		listOfFelines.add(new Lion("E Lion"));
		listOfFelines.add(new Cat("E Cat "));
		Feline maxF = max(listOfFelines);
		System.out.println(maxF);
		System.out.println("-------------------------------");
	}

}
