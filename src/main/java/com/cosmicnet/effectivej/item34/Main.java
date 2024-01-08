package com.cosmicnet.effectivej.item34;

public class Main {
	
	public static void main(String[] args) {
		PayrollDay pd = PayrollDay.FRIDAY;
		System.out.println("Payment on Friday for 9 hrs at PayRate 100 is : "+pd.pay(9, 100));
		pd = PayrollDay.SUNDAY;
		System.out.println("Payment on Sunday for 9 hrs at PayRate 100 is : "+pd.pay(9, 100));
		System.out.println("Payment on Sunday for 5 hrs at PayRate 100 is : "+pd.pay(5, 100));
	}

}
