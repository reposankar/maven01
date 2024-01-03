package com.cosmicnet.effectivej.item15;

import com.cosmicnet.effectivej.item07.Emp;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {

		PrivateStaticFinalObject po = new PrivateStaticFinalObject();
		System.out.println(po.BOARD_OF_DIRECTORS_LIST);


		System.out.println("-----------------------------");
		List<Emp> elist01 = po.BOARD_OF_DIRECTORS_LIST;
		elist01.set(1, new Emp("Ravi K"));
		System.out.println(po.BOARD_OF_DIRECTORS_LIST);
		
		

		System.out.println("-----------------------------");
		List<Emp> elist02 = po.getBoardOfDirectors();
		elist02.set(1, new Emp("Anjan Kumar"));
		System.out.println(po.BOARD_OF_DIRECTORS_LIST);
		
	}

}
