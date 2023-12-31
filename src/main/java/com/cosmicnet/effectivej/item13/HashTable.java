package com.cosmicnet.effectivej.item13;

import java.util.Objects;

public class HashTable implements Cloneable {
	
	private final int DEFAULT_BUCKETS_SIZE = 4;
	private int size = 0;
	private Entry[] buckets = new Entry[DEFAULT_BUCKETS_SIZE];
	
	private static class Entry {
		final Object key;
		Object value;
		Entry next;
		
		Entry(Object key, Object value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		Entry deepCopy() {
			//return new Entry(key, value, next == null ? null : next.deepCopy());
			Entry result = new Entry(key, value, next);
			for(Entry p = result; p.next != null; p = p.next) {
				p.next = new Entry(p.next.key, p.next.value, p.next.next);
			}
			return result;
		}
	}

	@Override
	public HashTable clone() {
		try {
			HashTable result = (HashTable) super.clone();
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
	
	public void put(final Object key, Object value) {
		Objects.requireNonNull(key);
		int hash = Math.floorMod(key.hashCode(), buckets.length);
		if (hash < 0) 
			throw new AssertionError("Invalid hash code for the key "+key); 
		if(buckets[hash] == null) {
			buckets[hash] = new Entry(key, value, null);
		} else {
			addEntryToBucket(buckets[hash], key, value);
		}
	}
	
	private void addEntryToBucket(Entry entry, Object key, Object value) {
		if (entry.next == null)
			entry.next = new Entry(key, value, null);
		else 
			addEntryToBucket(entry.next, key, value);
	}
	
	public Object get(Object key) {
		Objects.requireNonNull(key);
		int hash = Math.floorMod(key.hashCode(), buckets.length);
		return getFromList(buckets[hash], key);
	}
	
	private Object getFromList(Entry entry, Object key) {
		Object result = null;
		if(entry.key.equals(key))
			result = entry.value;
		else 
			result = getFromList(entry.next, key);
		return result;
	}
	@Override 
	public String toString() {
		StringBuilder result = new StringBuilder("[ ");
		for(Entry entry: buckets) 
			if(entry != null) {
				result.append("(");
				for (Entry p = entry; p != null; p = p.next) {
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



