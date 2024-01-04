package com.cosmicnet.effectivej.item31;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.cosmicnet.effectivej.item07.Emp;


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

	/*
	public static  <Z> void swap(List<? extends Z> list, int i, int j) {
		//list.set(j, list.set(i, list.get(j)));
		swapHelper(list, i, j);
	}
	public static <T, E extends T> void swapHelper(List<E> list, int i, int j) {
		list.set(j, list.set(i, list.get(j)));
	}
	*/
	
	//include simple wildcard generic for API release
	public static  void swap(List<?> list, int i, int j) {
		//list.set(j, list.set(i, list.get(j)));
		swapHelper(list, i, j);
	}
	public static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(j, list.set(i, list.get(j)));
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
		//System.out.println(max);
		System.out.println("-------------------------------");
		List<Feline> listOfFelines= new ArrayList<>();
		listOfFelines.add(new Cat("A Cat"));
		listOfFelines.add(new Cat("b Cat"));
		listOfFelines.add(new Cat("C Cat"));
		listOfFelines.add(new Lion("d Lion"));
		listOfFelines.add(new Lion("E Lion"));
		listOfFelines.add(new Cat("E Cat "));
		Feline maxF = max(listOfFelines);
		//System.out.println(maxF);

		System.out.println("-------------------------------");
		for(Iterator<Feline> i = listOfFelines.iterator(); i.hasNext();) 
			System.out.println(i.next());
		System.out.println("-------------------------------");
		swap(listOfFelines, 2, 3);
		for(Iterator<Feline> i = listOfFelines.iterator(); i.hasNext();) 
			System.out.println(i.next());

		
		List<Emp> listOfEmp= new ArrayList<>();
		listOfEmp.add(new Emp("A Cat"));
		listOfEmp.add(new Emp("b Cat"));
		listOfEmp.add(new Emp("C Cat"));
		listOfEmp.add(new Emp("d Lion"));
		listOfEmp.add(new Emp("E Lion"));
		listOfEmp.add(new Emp("E Cat "));
		System.out.println("-------------------------------");
		for(Iterator<Emp> i = listOfEmp.iterator(); i.hasNext();) 
			System.out.println(i.next());
		System.out.println("-------------------------------");
		swap(listOfEmp, 2, 3);
		for(Iterator<Emp> i = listOfEmp.iterator(); i.hasNext();) 
			System.out.println(i.next());
		
	}

}
