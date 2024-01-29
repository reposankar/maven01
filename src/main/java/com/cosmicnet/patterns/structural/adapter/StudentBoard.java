package com.cosmicnet.patterns.structural.adapter;

import java.util.List;
import java.util.ArrayList;

public class StudentBoard {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		Student collegeStudent01 = new CollegeStudent("Ravi", "Ayyeru", "ravi.ayyeru@gmail.com");
		Student collegeStudent02 = new CollegeStudent("Raju", "Karike", "raju.karike@gmail.com");
		Student collegeStudent03 = new CollegeStudent("Christopher", "Neerva", "cneerva200@gmail.com");
		Student collegeStudent04 = new CollegeStudent("Rosy", "Blunt", "rosybluntk@gmail.com");
		SchoolStudent schoolStudent01 = new SchoolStudent("James", "Martin", "martin_james21@yahoo.com");
		SchoolStudent schoolStudent02 = new SchoolStudent("Olivia", "Johnson", "oliviajohnson2016@gmail.com");
		SchoolStudentAdapter schoolStudentAdapter01 = new SchoolStudentAdapter(schoolStudent01);
		SchoolStudentAdapter schoolStudentAdapter02 = new SchoolStudentAdapter(schoolStudent02);
		studentList.add(collegeStudent01);
		studentList.add(collegeStudent02);
		studentList.add(collegeStudent03);
		studentList.add(collegeStudent04);
		studentList.add(schoolStudentAdapter01);
		studentList.add(schoolStudentAdapter02);
		for(Student s:studentList) {
			System.out.println(s);
		}
	}
}
