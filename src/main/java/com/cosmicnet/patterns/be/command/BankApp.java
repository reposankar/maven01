package com.cosmicnet.patterns.be.command;

import java.util.Arrays;
import java.util.List;

public class BankApp {
	
	public Account getSavingsAccount() {
		return new SavingsAccount();
	}
	

	
	
}
