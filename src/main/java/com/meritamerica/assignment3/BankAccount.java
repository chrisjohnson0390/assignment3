package com.meritamerica.assignment3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

	public  class  BankAccount {
	    private static double balance;
	    private static double interestRate;
	    private static Date accountOpenedOn;
	    static long  accountNumber;
	
	
	    public BankAccount(double balance, double interestRate) {
	        this.balance = balance;
	        this.interestRate = interestRate;
	        this.accountOpenedOn = null;
	    }
	    
	    BankAccount(double balance, double interestRate, Date accountOpenedOn){
	    	this.balance = balance;
	    	this.interestRate = interestRate;
	    	this.accountOpenedOn = accountOpenedOn;
	    }
	    
	   public BankAccount(long accountNumber, double balance, double interestRate, 
	    		Date accountOpenedOn){
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

	    public java.util.Date getOpenedOn() {
	        return accountOpenedOn;
	    }

	    /*public boolean withdraw(double amount) {
	        if (amount > balance) {
	            System.out.println("Not enough money in the account.");
	            return false;
	        } else {
	            balance -= amount;
	            System.out.println("Transaction Complete.");
	            return true;
	        }
	    }*/
	    public boolean withdraw(double amount) {
			if(amount <= balance && amount>0 ) {
				this.balance -= amount;
				System.out.println("Withdrawn amount: $" + amount);
				System.out.println("Remaining balance: $" + balance);
				return true;
			}
			return false;
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
	    	StringBuilder accountData = new StringBuilder();
	    	accountData.append(accountNumber).append(",");
	    	accountData.append(accountOpenedOn).append(",");
	    	accountData.append(balance).append(",");
	    	accountData.append(interestRate);
	    	return accountData.toString();
	    }
	    
	    //Overall goal: parse information from a string and create a new account with it.
	    public static BankAccount readFromString(String accountData)throws ParseException, NumberFormatException {
	    	try {
	    		String [] holding = accountData.split(",");
	    		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");//.parse(holding[3]);
	    		//[0] is accountNumber, [1] is balance, [2] is interestRate, date is [3] which is SimpleDate
	    		//BankAccount newAcct = new BankAccount(Long.valueOf(holding[0]),Double.valueOf(holding[1]),Double.valueOf(holding[2]),date);
	    		//return newAcct;
	    		
	    		 Long accountNumber = Long.parseLong(holding[0]);
	             double balance = Double.parseDouble(holding[1]);
	             double interestRate = Double.parseDouble(holding[2]);
	             Date accountOpenedOn = date.parse(holding[3]);

	             return new BankAccount(accountNumber, balance, interestRate, accountOpenedOn);
	    		
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


