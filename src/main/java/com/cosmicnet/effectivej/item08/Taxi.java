package com.cosmicnet.effectivej.item08;

public class Taxi implements Cloneable{
	public enum TaxiType {MINI, HATCH_BACK, SEDAN, SUV}
	private boolean booked = false;
	private String regNumber;
	private TaxiType type;
	
	public Taxi() {
		super();
	}
	
	public Taxi(String regNumber, TaxiType type) {
		this.regNumber = regNumber;
		this.type = type;
	}
	
	public boolean isBooked() {
		return booked;
	}
	
	public TaxiType getType() {
		return type;
	}
	
	public String getRegNumber() {
		return regNumber+" "+type;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) { 
		Taxi t = (Taxi) obj;
		return t.regNumber == this.regNumber && t.type == this.type;
	}
	@Override
	public String toString() {
		return getRegNumber()+" "+getType() ;
	}
	
}
