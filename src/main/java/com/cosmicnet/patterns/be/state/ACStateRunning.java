package com.cosmicnet.patterns.be.state;

public class ACStateRunning implements ACState {
	
	private AC ac;
	
	public ACStateRunning(AC ac) {
		this.ac = ac;
	}

	@Override
	public void pressStartButton() {
		System.out.println("AC is already running. No action needed.");
	}

	@Override
	public void pressStopButton() {
		if (ac.getIsWorking()) {
			ac.setState(ac.getACStateStopped()); 
			System.out.println("AC is stopped");
		} else
			System.out.println("Beep: AC is not working. Needs repair");
		
	}
	
	@Override
	public void repairAC() {
		//throw new UnsupportedOperationException("AC is already running. Repair can't be performed on running AC.");
		System.out.println("AC is already running. Repair can't be performed on running AC.");
	}
	
	@Override
	public String toString() {
		return "AC is in Running State.";
	}

}
