package com.cosmicnet.effectivej.item45;

import java.util.stream.Stream;

import com.cosmicnet.effectivej.item34.*;

import static com.cosmicnet.effectivej.item34.PayrollDay.*;
import static java.util.stream.Collectors.*;
import java.util.Map;

public class StreamCollectorsTest {
	
	public static void main(String[] args) {
		Map<String, PayrollDay> map = 
				Stream.of(PayrollDay.values())
				.collect(toMap(Object::toString, e -> e));
		
		for (Map.Entry entry:map.entrySet()) {
			//System.out.println(entry.getKey()+" <==> "+entry.getValue()); 
		}
		
		
		
		
		
	}

}
