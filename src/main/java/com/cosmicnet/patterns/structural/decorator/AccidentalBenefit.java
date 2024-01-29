package com.cosmicnet.patterns.structural.decorator;

public class AccidentalBenefit extends AddonDecorator{
	
	private final static double fixedComponent = 20;
	private final static double percentileComponent = 2;

	AccidentalBenefit(InsurancePlan basePlan) {
		super(basePlan);
	}
	@Override
	public String getInsuranceDetails() { 
		return super.getInsuranceDetails()+" plus Accidental Benefit";
	}
	
	@Override
	public double getPremium() {
		double baseComponent = super.getPremium();
		return (baseComponent*(1+(percentileComponent/100)))+fixedComponent;
	}

}
