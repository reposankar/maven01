package com.cosmicnet.patterns.structural.decorator;

public class CriticalCareBenefit extends AddonDecorator{

	private final static double fixedComponent = 32;

	CriticalCareBenefit(InsurancePlan basePlan) {
		super(basePlan);
	}

	@Override
	public String getInsuranceDetails() { 
		return super.getInsuranceDetails()+" plus Critical Care Benefit";
	}

	@Override
	public double getPremium() {
		double baseComponent = super.getPremium();
		return baseComponent+fixedComponent;
	}

}