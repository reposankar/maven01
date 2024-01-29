package com.cosmicnet.effectivej.item45.max;

public class Artist implements Comparable<Artist>{
	private String name;
	Artist(String name) {
		this.name = name;
	}
	
	public void setArtist(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Artist))
			return false;
		Artist a = (Artist) o;
		return name.equals(a.name);
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result = result * 31 + name.hashCode();
		return result;
	}
	
	@Override
	public int compareTo(Artist o) {
		if(!(o instanceof Artist))
			throw new IllegalArgumentException("invalid argument passed to Album compareTo");
		return name.compareTo(o.name); 
	}

}
