package com.cosmicnet.patterns.be.command;

public class SavingsAccount implements Account{

	private double balance = 0;
	@Override
	public void deposit() {
		balance += 1;
		
	}
	@Override
	public void deposit(double amount) {
		balance += amount;
		
	}

	@Override
	public void withdraw(double amount) {
		if (balance - amount < 0)
			throw new AssertionError("Insufficient Balance");
		balance -= amount;
		
	}
	@Override
	public void withdraw() {
		if (balance - 1 < 0)
			throw new AssertionError("Insufficient Balance");
		balance -= 1;
		
	}

	@Override
	public double balance() {
		return balance;
	}
	
	@Override
	public void transfer(Account toAccount, double amount) {
		if (balance - amount < 0)
			throw new AssertionError("Insufficient Balance. Can't transfer the amount");
		
		balance -= amount;
		toAccount.deposit(amount);
	}

}
