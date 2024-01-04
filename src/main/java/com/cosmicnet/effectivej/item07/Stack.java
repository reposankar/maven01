package com.cosmicnet.effectivej.item07;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<T> implements Iterable{
	private T[] array;
	private int size = 0;
	private static final int DEFAULT_INITIAL_SIZE = 16;
	Stack() {
		array =  (T[]) new Object [DEFAULT_INITIAL_SIZE]; 
	}

	public void push(T obj) {
		ensureSize();
		array[size++] = obj;
	}

	public T pop() {
		if (size == 0)
			throw new EmptyStackException();
		T x = array[--size];
		array[size] = null;
		return x;
	}

	public boolean hasNext() {
		return size > 0 ? true: false;
	}
	
	private void ensureSize() {
		if(array.length == size)
			array = Arrays.copyOf(array, array.length*2+1);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		Iterator<T> it = new StackIterator<>(this);
		return it;
	}

}
