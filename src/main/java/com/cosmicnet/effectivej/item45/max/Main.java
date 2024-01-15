package com.cosmicnet.effectivej.item45.max;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

//import java.util.Random;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class Main {
	public static void main(String[] args) {
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
		List<Album> albumList = Arrays.asList(album1, album2, album3, album4, album5
				                            , album6, album7, album8, album9, album10
				                            , album11, album12, album13, album14, album15 );

		//Map<Artist, Album> map = albumList.stream().collect(Collectors.toMap(Album::getArtist, Function.identity(), BinaryOperator.maxBy(comparingInt(Album::getSales))));
		Map<Artist, Album> map = albumList.stream().sorted(comparing(Album::getArtist)).collect(Collectors.toMap(Album::getArtist
				, Function.identity()
				, BinaryOperator.maxBy(comparingInt(Album::getSales))
				, ()-> new LinkedHashMap<>()
				)).entrySet().stream().limit(3).collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		//.limit(3)
		//, maxBy(comparing(x->x.getSales()))
		System.out.println(map);
		
	}
}
