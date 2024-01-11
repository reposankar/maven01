package com.cosmicnet.effectivej.item45;

import java.util.Arrays;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Stream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.Set;



public class AnagramStream {
	//----------------------------------------------------------------------------
	public static void main(String[] args) {
		Path path = Paths.get(Objects.requireNonNull(args[0]));
		final int minGroupSize = Integer.parseInt(Objects.requireNonNull(args[1]));
		try(Stream<String> words = Files.lines(path)) {
			words.collect(Collectors.groupingBy(word->aplhabetise(word)))
				.values().stream()
				.map(
						x-> {
							Set<String> stringSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
							stringSet.addAll(x);
							return stringSet;
						}
				)
				.filter(group->group.size()>=minGroupSize)
				.forEach(System.out::println);
		} catch (IOException fex) {
			System.out.println("Error : IO - "+fex);
		}
	}
	//-------------------------------------------------------------------------------
	public static String aplhabetise(String s) {
		char[] ca = s.toLowerCase().toCharArray();
		Arrays.sort(ca);
		return new String(ca);
	}

}
