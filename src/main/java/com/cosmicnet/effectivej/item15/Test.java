package com.cosmicnet.effectivej.item15;

import com.cosmicnet.effectivej.item07.Emp;

public class Test {

	public static void main(String[] args) {

		PublicStaticFinalObject po = new PublicStaticFinalObject();
		for (int i = 0; i < po.BOARD_OF_DIRECTORS.length; i++) {
			System.out.println(po.BOARD_OF_DIRECTORS[i]);
		}

		System.out.println("-----------------------------");
		Emp[] elist01 = new Emp[4];
		elist01 = po.BOARD_OF_DIRECTORS;
		elist01[1] = new Emp("Ravi K");
		for (int i = 0; i < po.BOARD_OF_DIRECTORS.length; i++) {
			System.out.println(po.BOARD_OF_DIRECTORS[i]);
		}

		System.out.println("-----------------------------");
		Emp[] elist02 = new Emp[4];
		elist02 = po.getBoardOfDirectors();
		elist02[1] = new Emp("Azar Ahmed Tarik");
		for (int i = 0; i < po.BOARD_OF_DIRECTORS.length; i++) {
			System.out.println(po.BOARD_OF_DIRECTORS[i]);
		}

		System.out.println("-----------------------------");
		Emp[] elist03 = new Emp[4];
		elist03 = po.getBoardOfDirectorsImmutable();
		elist03[1] = new Emp("Anil Kapoor");
		for (int i = 0; i < po.BOARD_OF_DIRECTORS.length; i++) {
			System.out.println(po.BOARD_OF_DIRECTORS[i]);
		}

		System.out.println("-----------------------------");

	}

}
