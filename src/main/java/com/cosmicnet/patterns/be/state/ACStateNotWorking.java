package com.cosmicnet.patterns.be.state;

public class ACStateNotWorking implements ACState{
	
	private AC ac;
	
	public ACStateNotWorking(AC ac) {
		this.ac = ac;
	}

	@Override
	public void pressStartButton() {
		throw new UnsupportedOperationException("Beep: AC is out of order.");
		
	}

	@Override
	public void pressStopButton() {
		System.out.println("Beep: AC is out of order and no action needed.");
		
	}

	@Override
	public void repairAC() {
		ac.setIsWorking(true);
		ac.setState(ac.getACStateStopped());
		System.out.println("AC is repaired.");
	}
	
	@Override
	public String toString() {
		return "AC is in Not Working State.";
	}

}
