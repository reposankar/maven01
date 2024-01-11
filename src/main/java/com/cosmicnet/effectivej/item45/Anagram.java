package com.cosmicnet.effectivej.item45;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.function.*;

public class Anagram {
	
	public static void main(String[] args) {
		int counter = 0;
		File path = new File(Objects.requireNonNull(args[0]));
		//File path = new File("C:\\D\\test\\java\\t1.txt");
		int minWordLength = Integer.parseInt(Objects.requireNonNull(args[1]));
		Map<MyString, Set<MyString>> groups = new HashMap<>();
		try(Scanner sc = new Scanner(path)) {
			while(sc.hasNext()) {
				MyString word = new MyString(sc.next());
				Function<MyString, String> fun = x -> x.toString().toLowerCase();
				//
				//groups.computeIfAbsent(orderStringAsc(word), x -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER)).add(word);
				groups.computeIfAbsent(orderStringAsc(word), x -> new TreeSet<>(Comparator.comparing(fun))).add(word);
				//groups.computeIfAbsent(orderStringAsc(word), x -> new HashSet<>()).add(word);
			}
		} catch (FileNotFoundException fnfex) {
			System.out.println("Error : File Not Found "+fnfex);
		}
		for(Map.Entry<MyString, Set<MyString>> group : groups.entrySet()) {
			if(group.getValue().size() >= minWordLength) {
				
				System.out.print(++counter + " " +group.getKey()+" : ");
				for(MyString word: group.getValue()) {
					System.out.print(word+ " ");
				}
				System.out.println("");
			}
		}

	}

	public static MyString orderStringAsc(MyString s) {
		char[] ca = s.toString().toLowerCase().toCharArray();
		Arrays.sort(ca);
		return new MyString(new String(ca));
	}

}
