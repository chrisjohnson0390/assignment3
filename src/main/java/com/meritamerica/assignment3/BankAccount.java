package com.meritamerica.assignment3;

	import java.text.ParseException;
import java.util.Date;

	public class BankAccount {
	    private static double balance;
	    private static double interestRate;
	    private static Date accountOpenedOn;
	    static long  accountNumber;
	
	
	    BankAccount(double balance, double interestRate) {
	        this.balance = balance;
	        this.interestRate = interestRate;
	        this.accountOpenedOn = null;
	    }
	    
	    BankAccount(double balance, double interestRate, java.util.Date accountOpenedOn){
	    	this.balance = balance;
	    	this.interestRate = interestRate;
	    	this.accountOpenedOn = accountOpenedOn;
	    }
	    
	    BankAccount(long accountNumber, double balance, double interestRate, 
	    		java.util.Date accountOpenedOn){
	    	this.accountNumber = accountNumber;
	    	this.balance = balance;
	    	this.interestRate = interestRate;
	    	this.accountOpenedOn = accountOpenedOn;
	    }
	    //CD account was throwing an error, created an extra constructor.
	    public BankAccount(CDOffering offering, double openBalance) {
			// TODO Auto-generated constructor stub
		}

		public long getAccountNumber() {
	        return accountNumber;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public double getInterestRate() {
	        return interestRate;
	    }

	    public java.util.Date getAccountOpenedOn() {
	        return accountOpenedOn;
	    }

	    public boolean withdraw(double amount) {
	        if (amount > balance) {
	            System.out.println("Not enough money in the account.");
	            return false;
	        } else {
	            balance -= amount;
	            System.out.println("Transaction Complete.");
	            return true;
	        }
	    }
	    public boolean deposit(double amount) {
	        if (amount <= 0) {
	            System.out.println("Please deposit sufficient amount");
	            return false;
	        } else {
	            balance += amount;
	            System.out.println("Transation Complete");
	            return true;
	        }
	    }
	    public double futureValue(int years) {
	        // Calculate future value base on the formula: FV = PV(1 + i)^n
	        double futureVal = this.balance * Math.pow(1 + getInterestRate(), years);
	        return futureVal;
	    }
	   
	    public String writeToString() {
	    	String accountData = "";
	    	accountData += this.accountNumber + ",";
	    	accountData+= this.accountOpenedOn + ",";
	    	accountData+= this.balance + ",";
	    	accountData+= this.interestRate + ",";
	    	return accountData;
	    }
	    
	    //Overall goal: parse information from a string and create a new account with it.
	    public static BankAccount readFromString(String accountData)throws ParseException, NumberFormatException {
	    	//Define local variables  for the local variables. i.e. accountOpenedOn, accountNumber, etc.
	    	long nAccountNumber = accountNumber;
	    	Date nAccountOpenedOn = accountOpenedOn;
	    	double nInterestRate = interestRate;
	    	double nBalance = balance;
	    	// Parse the string and identify each of the values
	    		// Assign to each of the local values we Parse
	    		// Throw exception - NumberFormatException
	    	// Call bank account constructor, passing in those local variables. 
	    	//Return new bank account.
	    }
	}


