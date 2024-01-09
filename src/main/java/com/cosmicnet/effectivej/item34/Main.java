package com.cosmicnet.effectivej.item34;

public class Main {
	
	public static void main(String[] args) {
		PayrollDay pd = PayrollDay.FRIDAY;
		System.out.println("Payment on Friday for 9 hrs at PayRate 100 is : "+pd.pay(9, 100));
		pd = PayrollDay.SUNDAY;
		System.out.println("Payment on Sunday for 9 hrs at PayRate 100 is : "+pd.pay(9, 100));
		System.out.println("Payment on Sunday for 5 hrs at PayRate 100 is : "+pd.pay(5, 100));
		System.out.println("----------------------------------------------------------------");
		testG(PayrollDay.class, 9, 100);
	}
	
	public static void test(double hoursWorked, double payRate) {
		for(PayrollDay p:PayrollDay.values()) {
			System.out.println(p+" "+p.pay(hoursWorked, payRate));
		}
	}
	public static <E extends Enum<E> & Payroll>void testG(Class<E> e, double hoursWorked, double payRate) {
		for(Payroll p:e.getEnumConstants()) {
			System.out.println(p+" "+p.pay(hoursWorked, payRate));
		}
	}

}
