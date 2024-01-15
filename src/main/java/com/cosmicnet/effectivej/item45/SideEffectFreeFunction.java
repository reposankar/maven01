package com.cosmicnet.effectivej.item45;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;


public class SideEffectFreeFunction {
	public static void main(String[] args) {
		
		// Stream used to change the status of Map during it pile line operation which 
		// is considered to be streams using side effect function.
		Map<String, Long> freq1 = new HashMap<>();
		/*
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			words.forEach(word->{freq1.merge(word.toLowerCase(), 1L, Long::sum);});
			//words.forEach(word->{freq.merge(word, 1L, (l, m)->Long.sum(l ,m));});
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		*/
		
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
		
		
		// 2.4) SECOND PARAMETER to set grouping results to a different type using MAPPING.
		// 2.4.a) from List<String> to String
		//-------------------------------------------------------------------------------------------
		
		Map<String, String> freq7 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq7 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), mapping(w->w.toLowerCase(), joining(", ", "Title [","]") )));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		//freq7.forEach((s, l)->System.out.println(s+" : "+l));
		
		// 2.4.b) MAPPING --> Changing resulted Map value and collection if required.
		//-------------------------------------------------------------------------------------------
		Map<String, Set<String>> freq7b = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq7b = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), mapping(w->w.toUpperCase(), toSet() )));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		
		//freq7b.forEach((s, l)->System.out.println(s+" : "+l));
		
		// 2.5) SECOND PARAMETER modifying return map type (From HashMap to like LinkedHashMap, EnumMap)
		//-------------------------------------------------------------------------------------------
		
		LinkedHashMap<String, Set<String>> freq8 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq8 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), () -> new LinkedHashMap<>(), toCollection(HashSet::new)));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}

		//freq8.forEach((s, l)->System.out.println(s+" : "+l));

		// 2.6) SECOND PARAMETER groupingByConcurrent
		//-------------------------------------------------------------------------------------------

		ConcurrentMap<String, Set<String>> freq9 = null;
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq9 = words.collect(groupingByConcurrent(w->w.toLowerCase().substring(0, 1), //toCollection(TreeSet::new) //toSet()
					                                                                       mapping(w->w.toUpperCase(), toCollection(TreeSet::new))
								  )
						   );
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}
		//freq9.forEach((s, l)->System.out.println(s+" : "+l));
		
		// 3) Ordering Example.
		// 3.1) ordering while getting data from stream.
		//-------------------------------------------------------------------------------------------
		
		Map<String, List<String>> freq10 = null;
		
		try(Stream<String> words = new Scanner(new File("C:\\D\\test\\java\\t2.txt")).tokens()) {
			//words.forEachOrdered(System.out::println);
			freq10 = words.collect(groupingBy(w->w.toLowerCase().substring(0, 1), toList()));
			//toCollection(ArrayList::new)));
		} catch (IOException ioex) {
			System.out.println("Error : "+ioex);
		}

		//freq10.forEach((s, l)->System.out.println(s+" : "+l));
		
		Set<Integer> set = new TreeSet<>(
				  Arrays.asList(-9, -5, -4, -2, 1, 2, 4, 5, 7, 9, 12, 13, 16, 29, 23, 34, 57, 102, 230));
		
		/*
		 List<Integer> ali = set.stream().limit(5).collect(toList());
		 
		System.out.println(ali);
		List<Integer> ali1 = set.stream().parallel().limit(5).collect(toList());
		System.out.println(ali1);
		List<Integer> ali2 = set.stream().unordered().parallel().limit(5).collect(toList());
		System.out.println(ali2);
		List<Integer> ali3 = set.stream().unordered().limit(5).collect(toList());
		System.out.println(ali3);
		List<Integer> list1 = Arrays.asList(-3, 10, -4, 1, 3);
		System.out.println(list1.stream().unordered().parallel().limit(3).sorted().collect(toList()));
		*/
		List<Integer> list1 = Arrays.asList(-3, 10, -4, 1, 3);
		//list1.stream().unordered().parallel().limit(5).forEachOrdered(System.out::println);
				//.collect(toList());
		//System.out.println(ali2);
		// 3.1) ordering after getting data to Map stream. Effectively ordering the Map.
		//-------------------------------------------------------------------------------------------
		List<String> list2 = Arrays.asList("A", "GG", "UU", "UUUUU", "BB", "BB", "BB", "UUU", "UU", "UU", "CCC");
		Map<String, String> map1 = list2.stream().collect(toMap(x->x.substring(0, 1), Function.identity(), (k,v)-> k+", "+v, LinkedHashMap::new));
		//System.out.println(map1);
		Map<String, List<String>> map2 = list2.stream().collect(groupingBy(x->x.substring(0, 1), LinkedHashMap::new, mapping(Function.identity(), toList())))
				.entrySet().stream()
				.sorted(comparing(x->x.getKey()))
				.collect(toMap(k->k.getKey(), v->v.getValue(), (v1,v2)-> merge(v1, v2), LinkedHashMap::new));
		//System.out.println(map2);
		
		//Map<String, Integer> map25 = list2.stream().collect(groupingBy(Function.identity(), LinkedHashMap::new, collectingAndThen(counting(), Long::intValue)) );
		Map<String, Integer> map25 = list2.stream().collect(groupingBy(Function.identity(), LinkedHashMap::new,  summingInt(x->x.length()) ) );
		System.out.println(map25);
		List<String> list251 = map25.keySet().stream()
				.sorted(comparing(map25::get).reversed())
				//.sorted(comparing(freq1.get).reversed())
				.limit(6)
				.collect(toList());
		System.out.println(list251);
		//-------------------------------------------------------------------------------------------------------------
		List<String> list3 = Arrays.asList("A", "GG", "UU", "UUUUU", "BB", "BB", "BB", "UUU", "UU", "UU", "CCC");
		//System.out.println(map1);
		Map<String, List<String>> map3 = list3.stream()
				.sorted(comparing(t->t))
				.collect(groupingBy(x->x.substring(0, 1), LinkedHashMap::new, mapping(Function.identity(), toList())));
		/*
				.entrySet().stream()
				.sorted(comparing(x->x.getKey()))
				.collect(toMap(k->k.getKey(), v->v.getValue(), (v1,v2)-> merge(v1, v2),LinkedHashMap::new));
		*/
		//System.out.println(map3);
		//-------------------------------------------------------------------------------------------------------------
		
	}
	public static <T>List<T> merge(List<T> l1, List<T> l2) {
		List<T> list = new ArrayList<>();
		list.addAll(l1);
		list.addAll(l2);
		return list;
	}
}
