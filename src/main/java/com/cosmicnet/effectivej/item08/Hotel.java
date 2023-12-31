package com.cosmicnet.effectivej.item08;

import java.util.concurrent.TimeUnit;

public class Hotel {
	private String name;
	Hotel(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) throws Exception {
		int numJunkPiles = 0;
		try ( Room room = new Room(numJunkPiles);
			  TaxiService ts = new TaxiService();
			) {
			System.out.println("Room is not yet allocated to A " +room.getJunkPiles());
			try {
				int numBookingDays = Room.MAX_STAY_IN_DAYS;
				room.useRoom(numBookingDays);
			} catch(AssertionError ae) {
				System.out.println("useRoom Exception "+ae);
			}
		}
		System.out.println("Before sleep");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException iex) {
			iex.printStackTrace();
		}
		System.out.println("-------------- End -------------");
		
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
