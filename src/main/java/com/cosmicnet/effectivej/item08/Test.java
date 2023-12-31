package com.cosmicnet.effectivej.item08;

public class Test {
	private final static int BUCKET_LENGTH = 16; 
	public static void main(String[] args) {
		int hash = 0;
		for(int i = 0; i < BUCKET_LENGTH * 3; i++) {
			System.out.print((hash = Math.floorMod(i, BUCKET_LENGTH))+" " );
		}
		
	}

}
