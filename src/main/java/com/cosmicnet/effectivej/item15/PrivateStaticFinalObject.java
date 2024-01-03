package com.cosmicnet.effectivej.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

import com.cosmicnet.effectivej.item07.Emp;

public class PrivateStaticFinalObject {
	
	private static final Emp[] BOARD_OF_DIRECTORS = new Emp[4];
	public static List<Emp> BOARD_OF_DIRECTORS_LIST;
	
	PrivateStaticFinalObject() {
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
		//BOARD_OF_DIRECTORS_LIST = Arrays.asList(BOARD_OF_DIRECTORS);
		BOARD_OF_DIRECTORS_LIST = Collections.unmodifiableList(Arrays.asList(BOARD_OF_DIRECTORS));
	}
	
	public List<Emp> getBoardOfDirectors() {
		return BOARD_OF_DIRECTORS_LIST;
	} 
	
	

}
