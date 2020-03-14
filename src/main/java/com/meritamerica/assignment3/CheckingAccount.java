package com.meritamerica.assignment3;

class CheckingAccount extends BankAccount {
	
	private double balance;
	private final double INTEREST_RATE = 0.0001;
	private long accountNumber;
	
	public CheckingAccount(double openBalance, double interestRate){
	super(openBalance, interestRate ); 
		this.balance = openBalance;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}

	public boolean withdraw(double amount) {
		if(amount <= balance && amount > 0) {
			this.balance = balance - amount;
			System.out.println("Withdrawn amount: " + amount);
			System.out.println("Remaining balance: " + balance);
			return true;
		}
		return false;
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			this.balance = balance + amount;
			System.out.println("Deposited amount: " + amount);
			System.out.println("Total balance: " + balance);
			return true;
		}
		return false;		
	}

	public double futureValue(int years) {
		return balance*Math.pow(1 + INTEREST_RATE, years);
	}
	
	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return INTEREST_RATE;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String toString() {
		return  "Checking Account Balance: $" + getBalance() + "\n" + 
				"Checking Account Interest Rate: " + INTEREST_RATE + "\n" + 
				"Checking Account Balance in 3 years: $" + futureValue(3);
		
	}
	//Still need the readFromString
}