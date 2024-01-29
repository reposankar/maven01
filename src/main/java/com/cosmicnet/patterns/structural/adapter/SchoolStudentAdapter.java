package com.cosmicnet.patterns.structural.adapter;

public class SchoolStudentAdapter implements Student{
	
	private SchoolStudent schoolStudent;
	
	SchoolStudentAdapter(SchoolStudent schoolStudent) {
		this.schoolStudent = schoolStudent;
	}

	@Override
	public String getName() {
		return schoolStudent.getFirstName();
	}

	@Override
	public String getSurname() {
		return schoolStudent.getLastName();
	}

	@Override
	public String getEmail() {
		return schoolStudent.getEmailAddress();
	}
	@Override
	public String toString() {
		return "School Student : "+getName()+" / "+getSurname()+" / "+getEmail();
	}
}
