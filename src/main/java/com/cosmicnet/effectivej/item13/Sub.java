package com.cosmicnet.effectivej.item13;

import java.time.*;

/**
 * 
 * @author Sankar M
 * @apiNote Example to show the incorrect usage of extension of superclass
 * 			in the presence of super class constructor overriding method.
 */
public class Sub extends Super{
	private final Instant instant;
	
	Sub() {
		instant = Instant.now();
	}
	
	@Override
	protected void overrideMe() {
		System.out.println("overrideMe from Sub "+instant);
	}
	
	public static void main(String[] args) {
		Super sub = new Sub();
		sub.overrideMe();
	}
	

}
