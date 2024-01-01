package com.cosmicnet.effectivej.item14;

import java.util.Objects;
import java.util.Comparator;

/**
 * 
 * @author Sankar M
 * @version 1.0
 * Description:
 * 	This class is to demonstrate clone and comparable functionality.
 *
 */

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
	private int areaCode;
	private int prefix;
	private int lineNumber;
	
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNumber = lineNumber;
	}
	
	
	public String toString() {
		return String.format("\n%03d-%03d-%03d", areaCode, prefix, lineNumber);
	}
	
	@Override
	public int hashCode() {
		int result = Objects.hash(areaCode);
		result = 31 * result + Objects.hash(prefix);
		result = 31 * result + Objects.hash(lineNumber);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		else if (!(obj instanceof PhoneNumber))
			return false;
		else {
			PhoneNumber pn = (PhoneNumber) obj;
			return areaCode == pn.areaCode && prefix == pn.prefix && lineNumber == pn.lineNumber;
		}
	}
	
	@Override
	public PhoneNumber clone() {
		PhoneNumber result = null;
		try {
			result=  (PhoneNumber) super.clone();		
		} catch(CloneNotSupportedException cloneex ) {
			cloneex.printStackTrace();
		}
		return result;
	}

	
	//compare using Comparator interface static method comparingInt & thenComparingInt methods.
	@Override
	public int compareTo(PhoneNumber ph) {
		/*
		int result = Integer.compare(areaCode, ph.areaCode);
		if(result == 0) {
			result = Integer.compare(prefix, ph.prefix);
			if(result == 0) {
				result = Integer.compare(prefix, ph.prefix);
			}
		}
		*/
		int result = Comparator
						.comparingInt((PhoneNumber x)-> x.areaCode)
						.thenComparingInt((PhoneNumber x)-> x.prefix)
						.thenComparingInt((PhoneNumber x)-> x.lineNumber)
						.compare(this, ph);
		return result;
	}
	
}
