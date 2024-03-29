package com.cosmicnet.effectivej.item45;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class DeckStream {
	public static void main(String[] args) {
		Stream.of(Suit.values())
			//.flatMap(suit -> Stream.of(Rank.values()).map(rank->new Card(suit, rank)))
			.flatMap(suit -> Stream.of(Rank.values()).map(rank->new Card(suit, rank)))
			.collect(groupingBy(card->card.getSuit()))
			//mapping(card->card.getSuit()+":"+card.getRank(), toSet())
			//.values()
			.entrySet()
			//.stream()
			.forEach(System.out::println);
		
		/*
		int x = 0;
		
		collect()
		Collectors.groupingBy
		
		*/
	}
}
