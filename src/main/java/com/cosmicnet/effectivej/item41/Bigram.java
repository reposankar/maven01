package com.cosmicnet.effectivej.item41;

import java.util.Set;
import java.util.HashSet;

public class Bigram {
	private char a;
	private char b;
	
	Bigram(char a, char b) {
		this.a = a;
		this.b = b;
	}
	
	
	public boolean equals(Bigram bi) {
		if (bi.a == this.a && bi.b == this.b)
			return true;
		return false;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof Bigram) {
			Bigram bg = (Bigram) obj;
			return bg.a == this.a && bg.b == this.b;
		}
		return false;
	}
	
	public int hashCode() {
		return 31 * a + b;
	}
	
	public String toString() {
		return a + "  " + b;
	}
	
	public static void main(String[] args) {
		Set<Bigram> bs = new HashSet<>();
		for(int i = 0; i < 10; i++)
			for (char ch = 'a'; ch <= 'z'; ch++)
				bs.add(new Bigram(ch, ch));
		System.out.println("Bigram Set size "+bs.size());
		System.out.println("Bigram Set :  "+bs);
	}
	

}
