package com.cosmicnet.patterns.be.command;

public class WithdrawCommand implements TransactionCommand {
	
	private Account account;
	private double amount;
	WithdrawCommand (Account account, double amount) {
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void execute() {
		account.withdraw(amount);
		
	}

}
