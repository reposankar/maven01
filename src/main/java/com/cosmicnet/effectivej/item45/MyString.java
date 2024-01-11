package com.cosmicnet.effectivej.item45;

public class MyString implements Comparable<MyString> {
	private String s;
	MyString(String s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return s;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o instanceof MyString ) {
			MyString other = (MyString) o;
			return s.equalsIgnoreCase(other.toString());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + ((s==null) ? 0 : s.toLowerCase().hashCode()) ;
		return result;
	}
	@Override
	public int compareTo(MyString o) {
		// TODO Auto-generated method stub
		return s.compareToIgnoreCase(o.toString());
	}

}
