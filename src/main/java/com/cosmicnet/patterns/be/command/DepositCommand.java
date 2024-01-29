package com.cosmicnet.patterns.be.command;

public class DepositCommand implements TransactionCommand {


	private Account account;
	private double amount;
	DepositCommand (Account account, double amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute() {
		account.deposit(amount);
		
	}


}
