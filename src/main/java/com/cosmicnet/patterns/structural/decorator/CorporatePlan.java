package com.cosmicnet.patterns.structural.decorator;

public class CorporatePlan implements InsurancePlan{

	private final static double corporatePlanPremium = 320.00;
	
	@Override
	public String getInsuranceDetails() { 
		return "Corporate Insurance Plan";
	}

	@Override
	public double getPremium() {
		return corporatePlanPremium;
	}

}
