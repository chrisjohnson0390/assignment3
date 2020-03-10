package com.meritamerica.assignment3;

class SavingsAccount {
	private double balance;
	private final double INTEREST_RATE = 0.01;
	private long acountNumber;
	
	public SavingsAccount(double openBalance){
		this.balance = openBalance;
		this.acountNumber = MeritBank.getNextAccountNumber();
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return INTEREST_RATE;
	}
	
	public long getAccountNumber() {
		return acountNumber;
	}
	
	public boolean withdraw(double amount) {
		if(amount <= balance && amount > 0) {
			this.balance = balance - amount;
			System.out.println("Withdrawn amount: $" + amount);
			System.out.println("Remaining balance: $" + balance);
			return true;
		}
		return false;
	}
	
	public boolean deposit(double amount) {
		if (amount > 0) {
			this.balance = balance + amount;
			System.out.println("Deposited amount: $" + amount);
			System.out.println("Total balance: $" + balance);
			return true;
		}
		return false;	
	}
	
	public double futureValue(int years) {
		return balance*Math.pow(1 + INTEREST_RATE, years);
	}
	
	public String toString() {
		return "Savings Account Balance: $" + balance + "\n" + 
				"Savings Account Interest Rate: " + INTEREST_RATE + "\n" + 
				"Savings Account Balance in 3 years: $" + futureValue(3);
	
	}

}