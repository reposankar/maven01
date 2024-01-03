package com.cosmicnet.effectivej.item15;

import java.util.Arrays;

import com.cosmicnet.effectivej.item07.Emp;

public class PublicStaticFinalObject {
	
	public static final Emp[] BOARD_OF_DIRECTORS = new Emp[4];
	PublicStaticFinalObject() {
		Emp e1 = new Emp("Rahul Sharma");
		Emp e2 = new Emp("Jogindar Kishan Dwivedi");
		Emp e3 = new Emp("Rohit Roy");
		Emp e4 = new Emp("Jaspal Singh");
		Emp e5 = new Emp("Kiran Kashyap");
		Emp e6 = new Emp("Joel Kinston");
		Emp e7 = new Emp("Murphy Broaston");
		BOARD_OF_DIRECTORS[0] = e2; 
		BOARD_OF_DIRECTORS[1] = e4; 
		BOARD_OF_DIRECTORS[2] = e7; 
		BOARD_OF_DIRECTORS[3] = e6; 
	}
	
	public Emp[] getBoardOfDirectors() {
		return BOARD_OF_DIRECTORS;
	}
	
	public Emp[] getBoardOfDirectorsImmutable() {
		return BOARD_OF_DIRECTORS.clone();
	}
	
	

}
