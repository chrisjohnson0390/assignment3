package com.meritamerica.assignment3;
//import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.lang.ArrayIndexOutOfBoundsException;
class CheckingAccount extends BankAccount {
	
	private double balance;
	private final double INTEREST_RATE = 0.0001;
	private long accountNumber;
	
	public CheckingAccount(double openBalance, double interestRate){
	super(openBalance, interestRate ); 
		this.balance = openBalance;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}
	
	public CheckingAccount ( long accountNumber, double openBalance, double interestRate, Date accountOpenedOn) {
		super(accountNumber, openBalance, interestRate, accountOpenedOn);
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
	public static CheckingAccount readFromString(String accountData)throws ParseException{ //NumberFormatException//, ArrayIndexOutOfBoundsException// 
	{
    	//try {
    		String [] holding = accountData.split(",");
    		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");//.parse(holding[3]);
    		//[0] is accountNumber, [1] is balance, [2] is interestRate, date is [3] which is SimpleDate
    		//CheckingAccount newCheckAcct = new CheckingAccount(Long.valueOf(holding[0]),Double.valueOf(holding[1]),
    			//	Double.valueOf(holding[2]),date);
    		
    		long accountNumber = Long.parseLong(holding[0]);
    		double balance = Double.parseDouble(holding[1]);
    		double interestRate = Double.parseDouble(holding[2]);
    		Date accountOpenedOn = date.parse(holding[3]);
    		
    		return new CheckingAccount(accountNumber, balance, interestRate, accountOpenedOn) ;
    		
    		
    	}
    	
    	
    	/*catch(ParseException  e) {
    		e.printStackTrace();
    		return null;
    	}
    	catch(NumberFormatException e) {
    		e.printStackTrace();
    		return null;
    	}
    	catch(ArrayIndexOutOfBoundsException e) {
    		e.printStackTrace();
    		return null;
    	}
    	/*catch(NullPointerException e) {
    		e.printStackTrace();
    		return null;
    	}*/
	}
	}
	
//}
	
    	