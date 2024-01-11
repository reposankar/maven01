package com.cosmicnet.effectivej.item45;

public class Card {
	
	private Suit suit;
	private Rank rank;
	
	Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	@Override
	public String toString() {
		return suit.toString()+" "+rank.toString();
	}
	
	public String getSuit() {
		return suit.toString();
	}
	
	public String getRank() {
		return rank.toString();
	}

}
