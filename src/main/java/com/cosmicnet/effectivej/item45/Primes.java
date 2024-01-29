package com.cosmicnet.effectivej.item45;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Primes {
	static Stream<BigInteger> primes() {
		return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
	}
	
	public static void main(String[] args) {
		primes().parallel().map(p->BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
				.filter(m->m.isProbablePrime(50))
				.limit(10)
				.forEach(System.out::println);
	}

}
