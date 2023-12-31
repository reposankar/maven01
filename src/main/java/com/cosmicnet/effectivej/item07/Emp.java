package com.cosmicnet.effectivej.item07;

public class Emp {
	private static int counter = 1;
	private final int id = counter++;
	private String name;
	private double salary;
	public Emp(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp "+id+") "+name+" ";
	}
	

}
