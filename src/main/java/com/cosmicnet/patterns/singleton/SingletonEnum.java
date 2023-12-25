package com.cosmicnet.patterns.singleton;

public enum SingletonEnum {
	RED,
	BLUE,
	YELLOW;
	
	SingletonEnum() {
		System.out.println("SingletonEnum is called in its constructor");
	}
	
	
	private int id;
	private String name;
	private String address;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}

	
	
	
}
