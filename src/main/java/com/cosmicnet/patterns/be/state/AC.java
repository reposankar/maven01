package com.cosmicnet.patterns.be.state;

public class AC {
	
	private ACState acState;
	private ACState acStateRunning;
	private ACState acStateStopped;
	private ACState acStateNotWorking;
	
	private boolean isWorking;
	
	AC() {
		acStateRunning = new ACStateRunning(this);
		acStateStopped = new ACStateStopped(this);
		acStateNotWorking = new ACStateNotWorking(this);
		
		acState = acStateStopped;
		isWorking = true;
	}

	public boolean getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}

	
	public void setState(ACState acState) {
		this.acState = acState; 
	}
	

	//State getters
	public ACState getState() {
		return acState;
	}
	public ACState getACStateRunning () {
		return acStateRunning;
	}
	public ACState getACStateStopped () {
		return acStateStopped;
	}
	public ACState getACStateNotWorking () {
		return acStateNotWorking;
	}

	//Action Methods.
	public void pressStartButton() {
		acState.pressStartButton();
	}
	public void pressStopButton() {
		acState.pressStopButton();
	}
	public void repairAC() {
		acState.repairAC();
	}


}
