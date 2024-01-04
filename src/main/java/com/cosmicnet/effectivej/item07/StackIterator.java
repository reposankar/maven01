package com.cosmicnet.effectivej.item07;

import java.util.Iterator;

public class StackIterator<T> implements Iterator {
	
	private Stack<T> stack;
	
	StackIterator(Stack<T> stack) {
		this.stack = stack;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return stack.hasNext();
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return stack.pop();
	}
	

}
