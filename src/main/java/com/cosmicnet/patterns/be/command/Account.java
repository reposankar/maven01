package com.cosmicnet.patterns.be.command;

public interface Account {
	public void deposit();
	public void deposit(double amount);
	public void withdraw();
	public void withdraw(double amount);
	public double balance();
	public void transfer(Account toAccount, double amount);

}
