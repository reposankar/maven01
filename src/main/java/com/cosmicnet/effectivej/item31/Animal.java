package com.cosmicnet.effectivej.item31;

public interface Animal extends Comparable<Animal> {
	
	public void eat();
	public void sleep();
	public void makeNoice();
	public String getName();
	public int compareTo(Animal o);

}
