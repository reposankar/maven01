package com.cosmicnet.effectivej.item45.max;

//import java.util.IllegalArgumentException;

public class Album implements Comparable<Album>{
	private Artist artist;
	private String name;
	private int sales;
	public Album(String name, Artist artist, int sales) {
		this.name = name;
		this.artist = artist;
		this.sales = sales;
	}
	public int getSales() {
		return sales;
	}
	public String getName() {
		return name;
	}
	public String getShortName() {
		return getName().substring(0, (getName().indexOf("-")<=-1)?getName().length():getName().indexOf("-")-1);
	}
	public Artist getArtist() {
		return artist;
	}
	
	public void setName(String name) {
		this.name = name+this.name;
	}
	
	
	@Override
	public String toString() {
		return "\n"+getShortName();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Album))
			return false;
		Album a = (Album) o;
		return name.equals(a.name) && artist.equals(a.artist) && sales == a.sales;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		result = result * 31 + artist.hashCode();
		result = result * 31 + name.replace("x", "").hashCode();
		result = result * 31 + sales;
		return result;
	}
	
	@Override
	public int compareTo(Album o) {
		if(!(o instanceof Album))
			throw new IllegalArgumentException("invalid argument passed to Album compareTo");
		return name.compareTo(o.name);
	}
}
