package com.cosmicnet.effectivej.item45;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeckStream {
	public static void main(String[] args) {
		Stream.of(Suit.values())
			//.flatMap(suit -> Stream.of(Rank.values()).map(rank->new Card(suit, rank)))
			.flatMap(suit -> Stream.of(Rank.values()).map(rank->new Card(suit, rank)))
			.collect(Collectors.groupingBy(card->card.getSuit())).values().stream()
			.forEach(System.out::println);
	}

}
