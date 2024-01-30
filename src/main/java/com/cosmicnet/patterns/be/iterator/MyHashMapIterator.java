package com.cosmicnet.patterns.be.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//import java.util.Set;
//import org.eclipse.collections.impl.set.mutable.UnifiedSet;

public class MyHashMapIterator<E> implements Iterator<E>{
	
	private HashMap<?, ?> hashMap;
	private int currentIndex = 0;
	private List<E> keySet;
	
	<K, V> MyHashMapIterator(HashMap<?, ?> hashMap) {
		this.hashMap = hashMap;  
		keySet = (List<E>) Arrays.asList(hashMap.keySet().toArray());
		//Collections.sort( keySet, Collections.reverseOrder().reversed()); 
		Comparator c = (x, y)->((String)x).length()<((String)y).length()?-1:(((String)x).length()==((String)y).length()?0:1);
		//Comparator c = (x, y)->Integer.valueOf(((String)x).length()).compareTo(Integer.valueOf(((String)y).length()))  ;
		Collections.sort( keySet, c);
	}
	

	@Override
	public boolean hasNext() {
		return currentIndex < keySet.size();
	}

	@Override
	public E next() {
		int i = currentIndex++;
		return (E) (keySet.get(i)+" : "+hashMap.get(keySet.get(i)));
	}

}
