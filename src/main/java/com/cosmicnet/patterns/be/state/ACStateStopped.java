package com.cosmicnet.patterns.be.state;

public class ACStateStopped implements ACState{

	private AC ac;

	public ACStateStopped(AC ac) {
		this.ac = ac;
	}

	@Override
	public void pressStartButton() {
		if (ac.getIsWorking()) {
			ac.setState(ac.getACStateRunning()); 
			System.out.println("AC is started");
		} else
			System.out.println("Beep: AC is not working. Needs repair");
	}

	@Override
	public void pressStopButton() {
		System.out.println("AC is already stopped. No action needed.");
	}

	@Override
	public void repairAC() {
		if (ac.getIsWorking()) {
			System.out.println("AC is in working consition. Repair is not needed.");
		} else {
			ac.setIsWorking(true);
			System.out.println("AC is repaired now!");
		}
	}
	
	@Override
	public String toString() {
		return "AC is in Stopped State.";
	}

}
