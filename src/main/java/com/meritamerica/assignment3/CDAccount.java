package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class CDAccount extends BankAccount {
	
	CDOffering offering;
	private int term;
	Date date;
	private double balance;
	private long accountNumber;
		
	/*public CDAccount(CDOffering offering, double openBalance){
		super(offering, openBalance);
		this.date = new Date();
		this.offering = offering;
		this.balance = openBalance;
		this.accountNumber = MeritBank.getNextAccountNumber();
	}*/
	
	
	public CDAccount(CDOffering offering, double openBalance) {
		super(openBalance,offering.getInterestRate());
		this.offering = offering;
		this.term = offering.getTerm();
	}
	
	public CDAccount(long accountNumber, double balance, double interestRate,Date accountOpenedOn, int term) {
		super(accountNumber, balance,interestRate,accountOpenedOn);
		this.term = term;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return offering.getInterestRate();
	}
	
	public int getTerm() {
		return offering.getTerm();
	}
	
	public Date getStartDate(){
		return date;
	}
	
	public long getAccountNumber() {
		return accountNumber;	
	}
	
	public double futureValue() {
		return futureValue(term);
	}
	
	@Override
	public boolean withdraw(double amount) {
        return false;
        }
    
    public boolean deposit(double amount) {
     return false;
    }
    
    public static CDAccount readFromString(String accountData)throws ParseException, NumberFormatException {
    	
    	//try {
    		String [] holding = accountData.split(",");
    		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");//.parse(holding[3]);
    		//[0] is accountNumber, [1] is balance, [2] is interestRate, date is [3] which is SimpleDate, [4] is term
    		//CDAccount newCDAcct = new CDAccount(Long.valueOf(holding[0]),Double.valueOf(holding[1]),Double.valueOf(holding[2]),
    			//	date, Integer.valueOf(holding[4]));
    		
    		long accountNumber = Long.parseLong(holding[0]);
    		System.out.println("RFT-CD -- account number: " +accountNumber);
    		double balance = Double.parseDouble(holding[1]);
    		System.out.println("RFT-CD -- balance: " +balance);
    		double interestRate = Double.parseDouble(holding[2]);
    		System.out.println("RFT-CD -- interest rate: " +interestRate);
    		Date accountOpenedOn = date.parse(holding[3]);
    		System.out.println("RFT-CD -- account opened on " +accountOpenedOn);
    		int term = Integer.parseInt(holding[4]);
    		System.out.println("RFT-CD -- term " +term);
    		return new CDAccount(accountNumber,balance,interestRate,accountOpenedOn,term);
    		
    	//}
    	/*catch(ParseException  e) {
    		e.printStackTrace();
    		return null;
    	}
    	catch(NumberFormatException e) {
    		e.printStackTrace();
    		return null;
    	}*/
    	
		
    }
    
    public String writeToString() {
    	StringBuilder override = new StringBuilder();
    	override.append(writeToString()).append(",");
    	override.append(term);
    	return override.toString();
    }

}