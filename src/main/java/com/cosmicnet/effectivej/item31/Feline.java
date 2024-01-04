package com.cosmicnet.effectivej.item31;

import java.util.Objects;

public class Feline implements Animal {

	private String name;

	Feline(String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println("Ites a Feline eat");
	}

	@Override
	public void sleep() {
		System.out.println("Ites a Feline sleep");
	}

	@Override
	public void makeNoice() {
		System.out.println("Ites a Feline noice");
	}

	@Override
	public String toString() {
		//return name.toLowerCase();
		return getName();
	}

	public String getName() {
		return name;
	}
	@Override
	public int compareTo(Animal o) {
		Objects.requireNonNull(o);
		//return this.toString().compareTo(o.toString());
		return this.getName().compareTo(o.getName());
	}

}
