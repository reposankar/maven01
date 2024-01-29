package com.cosmicnet.patterns.be.command;

public class TransferCommand implements TransactionCommand {


	private Account account1, account2; 
	private double amount;
	TransferCommand (Account account1, Account account2, double amount) {
		this.account1 = account1;
		this.account2 = account2;
		this.amount = amount;
	}

	@Override
	public void execute() {
		account1.transfer(account2, amount);
		
	}
}
