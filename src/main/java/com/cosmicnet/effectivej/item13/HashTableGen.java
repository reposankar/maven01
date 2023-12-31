package com.cosmicnet.effectivej.item13;

import java.util.Objects;

/**
 * 
 * @author Sankar M
 *
 * @param <K> Key
 * @param <V> Value
 * Description: This class is a HashTable implementation using "generics" of Key and Value
 * 				with "cloneable" functionality.  Implemented deep cloning using recursive 
 * 				method for its Linked List Entry object of each bucket.
 */
public class HashTableGen<K, V> implements Cloneable {
	
	private final int DEFAULT_BUCKETS_SIZE = 6;
	private int size = 0;
	private Entry[] buckets =  new Entry[DEFAULT_BUCKETS_SIZE] ;
	
	/*
	 * Linked List object's class.  This is a static class to hold 
	 * Entry object containing Key, value and next to point
	 * to the next Entry object in the liked list chain.
	 */	private static class Entry<KS, VS> {
		final KS key;
		VS value;
		Entry<KS, VS> next;
		
		//Linked List link object constructor.
		Entry(KS key, VS value, Entry<KS, VS> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		
		//Linked like link object Entry's deep cloning method using recursion. 
		Entry<KS, VS> deepCopy() {
			//return new Entry(key, value, next == null ? null : next.deepCopy());
			Entry<KS, VS> result = new Entry<>(key, value, next);
			for(Entry<KS, VS> p = result; p.next != null; p = p.next) {
				p.next = new Entry<>(p.next.key, p.next.value, p.next.next);
			}
			return result;
		}
	}

	@Override
	public HashTableGen<K, V> clone() {
		try {
			HashTableGen<K, V> result = (HashTableGen<K, V>) super.clone();
			result.buckets = new Entry[buckets.length];
			for(int i = 0; i < buckets.length; i++) {
				if(buckets[i]!= null)
					result.buckets[i] = buckets[i].deepCopy();
			}
			return result;
		} catch (CloneNotSupportedException cnex) {
			throw new AssertionError();
		}
	}
	
	
	//method to include data into HashTable
	public void put(final K key, V value) {
		Objects.requireNonNull(key);
		int hash = Math.floorMod(key.hashCode(), buckets.length);
		if (hash < 0) 
			throw new AssertionError("Invalid hash code for the key "+key); 
		if(buckets[hash] == null) {
			buckets[hash] = new Entry<>(key, value, null);
		} else {
			addEntryToBucket(buckets[hash], key, value);
		}
	}
	
	private void addEntryToBucket(Entry<K, V> entry, K key, V value) {
		if (entry.next == null)
			entry.next = new Entry<>(key, value, null);
		else 
			addEntryToBucket(entry.next, key, value);
	}
	
	//method to get value for a given key value of a HashTable instance.
	public V get(K key) {
		Objects.requireNonNull(key);
		int hash = Math.floorMod(key.hashCode(), buckets.length);
		return getFromList(buckets[hash], key);
	}
	
	private V getFromList(Entry<K, V> entry, K key) {
		V result = null;
		if(entry.key.equals(key))
			result = entry.value;
		else 
			result = getFromList(entry.next, key);
		return result;
	}
	
	//Typical toString implementation
	@Override 
	public String toString() {
		StringBuilder result = new StringBuilder("[ ");
		for(Entry<K, V> entry: buckets) 
			if(entry != null) {
				result.append("(");
				for (Entry<K, V> p = entry; p != null; p = p.next) {
					if(p.next==null)
						result.append(p.key+"="+p.value);
					else 
						result.append(p.key+"="+p.value+", ");
				}
				result.append(")\n");
			}
		result.append("]");
		return result.toString();
		
	}
}



