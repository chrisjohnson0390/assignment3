package com.meritamerica.assignment3;
import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class SavingsAccount extends BankAccount {
	private double balance;
	private final double INTEREST_RATE = 0.01;
	private long acountNumber;
	
	public SavingsAccount(double openBalance, double interestRate){
		super(openBalance, interestRate);
		this.balance = openBalance;
		this.acountNumber = MeritBank.getNextAccountNumber();
	}
	
	public SavingsAccount ( long accountNumber, double openBalance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, openBalance, interestRate, accountOpenedOn);
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
	
	/*public boolean withdraw(double amount) {
		if(amount <= balance && amount > 0) {
			this.balance = balance - amount;
			System.out.println("Withdrawn amount: $" + amount);
			System.out.println("Remaining balance: $" + balance);
			return true;
		}
		return false;
	}*/
	
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
	//Still need the readFromString
	
	public static SavingsAccount readFromString(String savingsAcctData)throws ParseException, NumberFormatException {
    	try {
    		String [] holding = savingsAcctData.split(",");
    		Date date = new SimpleDateFormat("dd/mm/yyyy").parse(holding[3]);
    		//[0] is accountNumber, [1] is balance, [2] is interestRate, date is [3] which is SimpleDate
    		SavingsAccount newSaveAcct = new SavingsAccount(Long.valueOf(holding[0]),Double.valueOf(holding[1]),Double.valueOf(holding[2]),date);
    		return newSaveAcct;
    	}
    	catch(ParseException  e) {
    		e.printStackTrace();
    		return null;
    	}
    	catch(NumberFormatException e) {
    		e.printStackTrace();
    		return null;
    	}

}
}