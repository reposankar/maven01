package com.cosmicnet.effectivej.item08;

import java.lang.ref.Cleaner;
import java.lang.ref.Cleaner.Cleanable;
import java.util.*;

import com.cosmicnet.effectivej.item08.Taxi.TaxiType;

public class TaxiService implements AutoCloseable{
 
	private static final Cleaner cleaner = Cleaner.create();
	private static final int TAXI_LIMIT = 30;
	private int ownedTaxies;
	private int hiredTaxies;
	private int availableTaxies;
	private Taxi hiredTaxi;
	private Set<Taxi> taxiSet = new HashSet<>();
	private static Random random = new Random(47);
	private Stack<Taxi> taxiStack = new Stack<>();
 
	
	
	private State state;
	private class State implements Runnable{
		@Override
		public void run() {
			returnTaxi();
		}
	}
	
	private final Cleanable cleanable;
	TaxiService() {
		ownedTaxies = 0;
		hiredTaxies = 0;
		availableTaxies = ownedTaxies;
		hiredTaxi = hireTaxi();
		state = new State();
		cleanable = cleaner.register(this, state);
	}

	private Taxi hireTaxi() {
		Taxi taxi;
		if (ownedTaxies < TAXI_LIMIT /* && ownedTaxies < (hiredTaxies + availableTaxies) */) {
			ownedTaxies++;
			hiredTaxies++;
			taxi = new Taxi("KA03ML43" + String.format("%02d", (hiredTaxies + availableTaxies)),
					TaxiType.values()[random.nextInt(3)]);
			taxiSet.add(taxi);
		} else {
			if (!taxiStack.empty()) {
				hiredTaxies++;
				availableTaxies--;
				taxi = taxiStack.pop();
			} else
				throw new AssertionError(
						"No more taxies available. Please reach to our customer care to schedule a taxi.");
		}
		System.out.println("Taxi "+taxi+" is hired.");
		return taxi;
	}
	/*
	 * public Taxi getHiredTaxi() throws CloneNotSupportedException{ return (Taxi)
	 * hiredTaxi.clone(); }
	 */

	public void returnTaxi() {
		if (hiredTaxies > 0) {
			hiredTaxies--;
			availableTaxies++;
			taxiStack.push(hiredTaxi);
			System.out.println("Taxi "+hiredTaxi+" is returned.");
		} else 
			throw new AssertionError("Not our company taxi.");
	}
	
	@Override
	public void close() { 
		cleanable.clean();
	}

}
