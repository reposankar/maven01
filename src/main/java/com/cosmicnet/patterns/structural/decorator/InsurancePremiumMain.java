package com.cosmicnet.patterns.structural.decorator;

public class InsurancePremiumMain {
	
	public static void main(String[] args) {
		InsurancePlan ajayPolicy = new PersonalPlan();
		InsurancePlan kiranPolicy = new CorporatePlan();
		System.out.println("ajayPolicy : "+ajayPolicy.getInsuranceDetails()+" | premium : "+ajayPolicy.getPremium());
		System.out.println("kiranPolicy : "+kiranPolicy.getInsuranceDetails()+" | premium : "+kiranPolicy.getPremium());
		ajayPolicy = new AccidentalBenefit(ajayPolicy);
		kiranPolicy = new CriticalCareBenefit(kiranPolicy);
		System.out.println("ajayPolicy : "+ajayPolicy.getInsuranceDetails()+" | premium : "+ajayPolicy.getPremium());
		System.out.println("kiranPolicy : "+kiranPolicy.getInsuranceDetails()+" | premium : "+kiranPolicy.getPremium());
	}

}





