package com.cosmicnet.effectivej.item13;

import java.util.Objects;

public class HashTableGen<K, V> implements Cloneable {
	
	private final int DEFAULT_BUCKETS_SIZE = 6;
	private int size = 0;
	private Entry[] buckets =  new Entry[DEFAULT_BUCKETS_SIZE] ;
	
	private static class Entry<KS, VS> {
		final KS key;
		VS value;
		Entry<KS, VS> next;
		
		Entry(KS key, VS value, Entry<KS, VS> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
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



