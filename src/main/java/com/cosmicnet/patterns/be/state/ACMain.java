package com.cosmicnet.patterns.be.state;

public class ACMain {
	
	public static void main(String[] args) {
		AC ac = new AC();
		System.out.println("AC State : "+ac.getState());
		ac.pressStartButton();
		ac.pressStartButton();
		ac.pressStopButton();
		ac.repairAC();
		ac.setIsWorking(false);
		ac.pressStartButton();
		ac.repairAC();
		ac.pressStartButton();
		ac.pressStopButton();
		System.out.println("AC State : "+ac.getState());
	}

}
