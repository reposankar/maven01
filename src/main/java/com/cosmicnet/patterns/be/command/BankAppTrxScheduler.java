package com.cosmicnet.patterns.be.command;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BankAppTrxScheduler {
	
	private List<TransactionCommand> commandsListGlobal = new ArrayList<>();
	
	public <T extends TransactionCommand> List<T> scheduledTrasactionA(Account fromAccount, Account toAccount) {
		//Account fromAccount = getSavingsAccount();
		List<T> commandsList = new ArrayList<>();
		//commandsList.add((T) new DepositCommand(fromAccount, 1000)); 
		commandsList.add((T) new TransferCommand(fromAccount, toAccount, 50)); 
		commandsList.add((T) new WithdrawCommand(fromAccount, 90)); 
		commandsList.add((T) new DepositCommand(fromAccount, 5)); 
		commandsList = Collections.unmodifiableList(commandsList);
		return commandsList;
		
	}
	
	public <T extends TransactionCommand> List<T> undoScheduledTrasactionA(Account fromAccount, Account toAccount) {
		//Account fromAccount = getSavingsAccount();
		List<T> commandsList = new ArrayList<>();
		//commandsList.add((T) new DepositCommand(fromAccount, 1000)); 
		commandsList.add((T) new TransferCommand(toAccount, fromAccount, 50)); 
		commandsList.add((T) new DepositCommand(fromAccount, 90)); 
		commandsList.add((T) new WithdrawCommand(fromAccount, 5)); 
		commandsList = Collections.unmodifiableList(commandsList);
		
		return commandsList;
		
	}
	
	public <T extends TransactionCommand> void addCommandToBatch (Account fromAccount, Account toAccount, T t) {
		//Account fromAccount = getSavingsAccount();
		//commandsList.add((T) new DepositCommand(fromAccount, 1000)); 
		commandsListGlobal.add(t); 
		//commandsListGlobal = Collections.unmodifiableList(commandsListGlobal);
		
	}
	
	public <T extends TransactionCommand> List<T> getCommandsBatch () {		
		return (List<T>)commandsListGlobal;
	}

}
