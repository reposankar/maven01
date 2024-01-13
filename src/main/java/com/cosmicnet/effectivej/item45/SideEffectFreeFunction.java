package com.cosmicnet.effectivej.item45;

import java.util.Map;
import java.util.Optional;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


public class SideEffectFreeFunction {
	public static void main(String[] args) {
		
		// Stream used to change the status of Map during it pile line operation which 
		// is considered to be streams using side effect function.
		Map<String, Long> freq = new HashMap<>();
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			words.forEach(word->{freq.merge(word.toLowerCase(), 1L, Long::sum);});
			//words.forEach(word->{freq.merge(word, 1L, (l, m)->Long.sum(l ,m));});
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		/*
		 * for(Map.Entry<String, Long> e : freq.entrySet()) {
		 * System.out.println(e.getKey()+" - "+e.getValue()); }
		 */
		
		//freq.forEach((s, l)->System.out.println(s+" : "+l));
		
		//Side effect free function usage.
		Map<String, Long> freq2 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq2 = words.collect(groupingBy(w->w.toLowerCase(), counting()));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		//freq2.forEach((s, l)->System.out.println(s+" : "+l));
		
		Map<String, List<String>> freq3 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq3 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1)));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		//freq3.forEach((s, l)->System.out.println(s+" : "+l));
		
		// 2) SECOND PARAMETER --> downstream examples.
		//===========================================================================================
		// 2.1) SECOND PARAMETER to define list Type. Ex: Set
		//-------------------------------------------------------------------------------------------
		
		Map<String, Set<String>> freq4 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq4 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), toSet()));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		//freq4.forEach((s, l)->System.out.println(s+" : "+l));
		
		
		// 2.2) SECOND PARAMETER to define other grouping. (Multiple grouping)
		//-------------------------------------------------------------------------------------------
		Map<String, Map<String, Set<String>>> freq5 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq5 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), groupingBy(x->x.toLowerCase().substring(0, 2), toSet())));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		//freq5.forEach((s, l)->System.out.println(s+" : "+l));
		
		// 2.3) SECOND PARAMETER to define Aggregation functions. 
		// Ex: counting, averagingInt, sumingInt, maxBy, minBy, summarizingInt
		//-----------------------------------------------------------------------------------------------
		
		//Map<String, Optional<String>> freq6 = null;
		Map<String, IntSummaryStatistics> freq6 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			//freq6 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), counting()));
			//freq6 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), summingInt(w->w.length())));
			//freq6 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), maxBy(comparingInt(w->w.length()))));
			freq6 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), summarizingInt(w->w.length())));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		//freq6.forEach((s, l)->System.out.println(s+" : "+l));
		
		
		// 2.4) SECOND PARAMETER to set grouping results to a different type. from List<String> to String
		//-------------------------------------------------------------------------------------------
		
		Map<String, String> freq7 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq7 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), mapping(w->w.toLowerCase(), joining(", ", "Title [","]") )));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		//freq7.forEach((s, l)->System.out.println(s+" : "+l));
		
		// 2.5) SECOND PARAMETER modifying return map type (From HashMap to like LinkedHashMap, EnumMap)
		//-------------------------------------------------------------------------------------------
		
		LinkedHashMap<String, List<String>> freq8 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq8 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), () -> new LinkedHashMap<>(), toList()));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		//freq8.forEach((s, l)->System.out.println(s+" : "+l));
		
		// 2.6) SECOND PARAMETER groupingByConcurrent
		//-------------------------------------------------------------------------------------------
				
		ConcurrentMap<String, Set<String>> freq9 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq9 = words.collect(groupingByConcurrent(w->w.toLowerCase().substring(0, 1), toSet()));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		freq9.forEach((s, l)->System.out.println(s+" : "+l));


		
		
		
		
	}
}
