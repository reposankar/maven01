package com.cosmicnet.effectivej.item08;

import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;
import java.time.LocalDate;

public class Room implements AutoCloseable{
	private static final Cleaner cleaner = Cleaner.create();
	public static final int MAX_STAY_IN_DAYS;
	static {
		int days = LocalDate.of(LocalDate.now().getYear(), 12, 31).getDayOfYear();
		System.out.println("days : "+days);
		MAX_STAY_IN_DAYS = days;
	}
	State state;
	private class State implements Runnable {
		int numJunkPiles;
		State(int numJunkPiles) {
			this.numJunkPiles = numJunkPiles;
		}
		@Override
		public void run() {
			System.out.println("You are in run()");
			if(numJunkPiles > MAX_STAY_IN_DAYS)
				throw new AssertionError("Junk Piles are too high. Can't be cleaned by a regular cleaning job. "
						+ "Assign a special cleaning task to get this room cleaned.");
			numJunkPiles = 0;
		}
	}
	
	
	private final Cleanable cleanable;
	public Room(int numJunkPiles) {
		state = new State(numJunkPiles);
		cleanable = cleaner.register(this, state);
		System.out.println("Room - numJunkPiles "+numJunkPiles);
	}
	
	public void useRoom(int numDays) {
		if(numDays < 1 )
			throw new AssertionError("Rooms can't be booked for less than a day.");
		//if(numDays > MAX_STAY_IN_DAYS)
		//	throw new AssertionError("Rooms can't be booked for more than an year.");
		for(int i = 0; i < numDays; i++) {
			state.numJunkPiles++;
		}
	}
	
	public int getJunkPiles() {
		return state.numJunkPiles;
	}

	@Override
	public void close() throws Exception {
		System.out.println("close 1  - numJunkPiles "+state.numJunkPiles);
		cleanable.clean();
		System.out.println("close 2 - numJunkPiles "+state.numJunkPiles);
	}
	
	

}
