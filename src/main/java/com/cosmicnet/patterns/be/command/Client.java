package com.cosmicnet.patterns.be.command;

import java.util.List;

public class Client {
	public static void main(String[] args) {
		BankApp bankAppUserSession = new BankApp();
		Account userAccout = bankAppUserSession.getSavingsAccount();
		TransactionCommand depositTransactionCommand = new DepositCommand(userAccout, 1000);
		depositTransactionCommand.execute(); 
		Account toAccount = new SavingsAccount();
		//TransactionCommand transferTransactionCommand = new TransferCommand(userAccout, toAccount, 50);
		//transferTransactionCommand.execute();
		

		BankAppTrxScheduler bankAppTrxScheduler = new BankAppTrxScheduler();
		List<TransactionCommand> commandsList = bankAppTrxScheduler.scheduledTrasactionA(userAccout, toAccount);

		
		List<TransactionCommand> undoCommandsList = bankAppTrxScheduler.undoScheduledTrasactionA(userAccout, toAccount);
		//-------------------------------------------------------------------
		System.out.println("3 --> "+userAccout.balance()+" , "+toAccount.balance()); 
		
		//--Execute batch commands:
		for(TransactionCommand t:commandsList) t.execute();
		System.out.println("4 --> "+userAccout.balance()+" , "+toAccount.balance());
		
		
		//--Execute Undo batch commands:
		for(TransactionCommand t:undoCommandsList) t.execute();
		System.out.println("5 --> "+userAccout.balance()+" , "+toAccount.balance()); 
		bankAppTrxScheduler.addCommandToBatch(userAccout, toAccount, userAccout::deposit);
		bankAppTrxScheduler.addCommandToBatch(userAccout, toAccount, depositTransactionCommand);
		bankAppTrxScheduler.addCommandToBatch(userAccout, toAccount, ()->userAccout.deposit(500));
		bankAppTrxScheduler.addCommandToBatch(userAccout, toAccount, userAccout::withdraw);
		List<TransactionCommand> commandsBatchList = bankAppTrxScheduler.getCommandsBatch();
		for(TransactionCommand t:commandsBatchList) t.execute();
		System.out.println("5 --> "+userAccout.balance()+" , "+toAccount.balance()); 
		
	}

}
