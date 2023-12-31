package com.cosmicnet.effectivej.item13;

public class Test {
	public static void main(String[] args) {

		
		HashTableGen<Integer, String> ht = new HashTableGen<>();
		ht.put(Integer.valueOf(1), "A");
		ht.put(2, "B");
		ht.put(3, "C");
		ht.put(4, "D");
		ht.put(5, "E");
		ht.put(6, "F");
		ht.put(7, "G");
		ht.put(8, "H");
		ht.put(9, "I");
		ht.put(10, "J");
		ht.put(11, "K");
		ht.put(12, "L");
		ht.put(13, "M");
		ht.put(14, "N");
		ht.put(15, "O");
		System.out.println(ht);
		System.out.println(ht.get(Integer.valueOf(10)));
		System.out.println(ht.get(4));
		System.out.println(ht.get(14));
		System.out.println(ht);
		
	}

}
