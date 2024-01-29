package com.cosmicnet.patterns.structural.decorator;

public abstract class AddonDecorator implements InsurancePlan{
	
	protected InsurancePlan basePlan;
	
	AddonDecorator(InsurancePlan basePlan) {
		this.basePlan = basePlan;
	}
	
	
	@Override
	public String getInsuranceDetails() { 
		return basePlan.getInsuranceDetails();
	}
	
	@Override
	public double getPremium() {
		return basePlan.getPremium();
	}



}
