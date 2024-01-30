package com.cosmicnet.patterns.be.iterator;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> extends AbstractMap<K,V> implements Map<K,V>{
	private HashMap<K, V> myHashMap;
	
	MyHashMap() {
		myHashMap = new HashMap<>();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return myHashMap.entrySet();
		//return null;
	}
	
	@Override
	public V put(K key, V value) {
		return myHashMap.put(key, value);
    }

	public Iterator<K> iterator() {
		return new MyHashMapIterator<>(myHashMap);
	}

	
	
	

}
