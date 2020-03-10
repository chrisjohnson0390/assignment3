package com.meritamerica.assignment3;

import java.util.Date;

class CDAccount {
	
	CDOffering offering;
	Date date;
	private double balance;
	private long accountNumber;
		
	public CDAccount(CDOffering offering, double openBalance){
		this.date = new Date();
		this.offering = offering;
		this.balance = openBalance;
		this.accountNumber = MeritBank.getNextAccountNumber();
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
	
	public java.util.Date getStartDate(){
		return date;
	}
	
	public long getAccountNumber() {
		return accountNumber;	
	}
	
	public double futureValue() {
		return balance*Math.pow(1 + getInterestRate(), getTerm());
	}

}