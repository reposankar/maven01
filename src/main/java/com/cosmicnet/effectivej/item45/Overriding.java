package com.cosmicnet.effectivej.item45;

import java.util.List;

class Wine {
	String name() {
		return "Wine";
	}
}

class SparklingWine extends Wine {
	String name() {
		return "SparklingWine";
	}
}

class Champagne extends SparklingWine {
	String name() {
		return "Champagne";
	}
}

public class Overriding {
	public static void main(String[] args) {
		List<Wine> wines = List.of(
				new Wine(), new SparklingWine(), new Champagne());
		for (Wine wine: wines) {
			System.out.println(wine.name());
		}
	}
}
