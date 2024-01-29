package com.cosmicnet.patterns.structural.decorator;

public class PersonalPlan implements InsurancePlan{
	
	private final static double personalPlanPremium = 450.00;

	@Override
	public String getInsuranceDetails() {
		return "Personal Insurance Plan";
	}

	@Override
	public double getPremium() {
		return personalPlanPremium;
	}

}
