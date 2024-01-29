package com.cosmicnet.effectivej.item45.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

import java.math.*;

//import java.util.Random;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Main {
	//public static void main(String[] args) {
	public static void main(String... ars) {
		Artist a1 = new Artist("Ram");
		Artist a2 = new Artist("Ajay Chandra");
		Artist a3 = new Artist("Rod Cliffon");
		Artist a4 = new Artist("Vijay R Karoli");
		Artist a5 = new Artist("Jayanth Roy");
		
		Album album1 = new Album("TinTon - Koreaon", a3, 4258);
		Album album2 = new Album("Mariam Koyal - Bengali", a4, 555);
		Album album3 = new Album("Vardhana Vyaas - Tamil", a1, 1693);
		Album album4 = new Album("Kirak Chak - Telugu", a1, 1861);
		Album album5 = new Album("Anul Bewafa - Hindi", a4, 1809);
		Album album6 = new Album("Namma Maniga - Kannada", a2, 429);
		Album album7 = new Album("Harahara - Telugu", a5, 4868);
		Album album8 = new Album("Kalasipalya - Kannada", a2, 200);
		Album album9 = new Album("Mrunal Vyagharkar - Bengal", a3, 4522);
		Album album10 = new Album("Moharam - Urdu", a1, 1207);
		Album album11 = new Album("Paniyaalam - Malayaalam", a5, 3288);
		Album album12 = new Album("Kiraak - Telugu", a3, 128);
		Album album13 = new Album("Rainbow Rain - English", a1, 3551);
		Album album14 = new Album("Slowly Slowly - English", a1, 4589);
		Album album15 = new Album("Mridwan Kalash - Sanskrit", a4, 961);
		List<Album> albumList = Arrays.asList(album1, album2
				, album3, album4, album5
				                            , album6, album7, album8, album9, album10
				                            , album11, album12, album13, album14, album15 );

		//System.out.println(albumList);

		//Set<Album> albumSet = new TreeSet<>(Comparator.comparing(Album::getName).reversed());
		//albumSet.addAll(albumList);
		//System.out.println(albumSet);
		//Map<Artist, Album> map = albumList.stream().collect(Collectors.toMap(Album::getArtist, Function.identity(), BinaryOperator.maxBy(comparingInt(Album::getSales))));
		Map<Artist, Album> map = albumList.stream().sorted(comparing(Album::getArtist)).collect(Collectors.toMap(Album::getArtist
				, Function.identity()
				//, BinaryOperator.minBy(comparingInt(Album::getSales))
				,BinaryOperator.minBy(comparingInt(Album::getSales))
				, ()-> new LinkedHashMap<>()
				)).entrySet().stream().limit(3).collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
		//.limit(3)
		//, maxBy(comparing(x->x.getSales()))
		//System.out.println(map);
		Map<Artist, Set<Album>> map2 = albumList
				.stream()
				.sorted(comparing(Album::getArtist))
				//.collect(toMap(Album::getArtist , Function.identity(), LinkedHashMap::new));
				.collect(groupingBy(Album::getArtist , HashMap::new, toCollection(TreeSet::new)));
		//.limit(3)
		//, maxBy(comparing(x->x.getSales()))
		//System.out.println(map2);
		/*
		System.out.println("-------------------- Rod Cliffon ------------------------");
		Set<Album> albumSet = map2.get(new Artist("Rod Cliffon"));
		for(Album a:albumSet)
			System.out.println(a.getName());
		System.out.println("-------------------- Rod Cliffon 2 ------------------------");
		
		Map<Album, Artist> map3 = albumList.stream()
				.sorted(comparing(Album::getName))
				.collect(toMap(Function.identity(), Album::getArtist));
		System.out.println(map3);
		System.out.println("-------------------- Rod Cliffon 3 ------------------------");
		System.out.println(map3.get(album10));
		System.out.println("-------------------- Rod Cliffon 4 ------------------------");
		Album album100 = new Album("Moharam - Urdu", a1, 1207);
		Album album101 = new Album("xMoharam - Urdu", a1, 1207);
		album10.setName("x");
		System.out.println(album10.getName());
		System.out.println("-------------------- Rod Cliffon 5 ------------------------");
		System.out.println(map3.get(album10));
		System.out.println(map3.get(album100));
		System.out.println(map3.get(album101));
		System.out.println("-------------------- Rod Cliffon 6 ------------------------");
		System.out.println(map3);
		*/
		
		/*
		 * BigDecimal p = new BigDecimal(370000.35); BigDecimal r = new
		 * BigDecimal(2.34); BigDecimal t = BigDecimal.valueOf(((4*30)+12)/365);
		 * //BigDecimal i = p.multiply(r).multiply(t).divide(r, 0, null);
		 * 
		 * double pf = 37000.35; double rf = 2.34; double tf = ((7.3515*30)+4.34)/365;
		 * double iff = pf*rf*tf/10; System.out.println(iff);
		 * 
		 * double pd = 37000.35; double rd = 2.34; double td = ((7.3515*30)+4.34)/365;
		 * //double id = pd*rd*td/100; BigDecimal ibigd =
		 * BigDecimal.valueOf(pd).multiply(BigDecimal.valueOf(rd)).multiply(BigDecimal.
		 * valueOf(td)).divide(BigDecimal.valueOf(10.0)); System.out.println(ibigd);
		 */
		
		List<Album> albumsByRam = albumList.stream().filter(x->x.getArtist().toString().equals("Ajay Chandra1")).collect(Collectors.toList());
		System.out.println(albumsByRam.size());
		
		Album[] albumArray = albumList.toArray(new Album[0]);
		
		for(int i = 0; i < albumArray.length; i++) {
			System.out.println(albumArray[i].getShortName());
		}
		
		System.out.println("----------------------------------------");
		
		for(Album a:albumArray) {
			System.out.println(a.getName());
		}
		System.out.println("----------------------------------------");
		albumList.stream().filter(x->!x.getShortName().startsWith("Tin")).map(Album::getShortName).forEach(System.out::println);
		System.out.println("----------------------------------------");

	}
}
