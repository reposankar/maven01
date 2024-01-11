package com.cosmicnet.effectivej.item45;

import java.util.List;
import java.util.ArrayList;


public class Deck {
	
	public static void main(String[] args) {
		int counter = 0;
		List<Card> cards = new ArrayList<>();
		for(Suit suit : Suit.values())
			for(Rank rank : Rank.values())
				cards.add(new Card(suit, rank));
		for(Card card:cards)
			System.out.println(++counter +" "+card);
	}
}
