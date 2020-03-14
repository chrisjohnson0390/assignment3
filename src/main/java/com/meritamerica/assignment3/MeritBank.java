package com.meritamerica.assignment3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class MeritBank {
	
	private static long nextAccountNumber = 84920570;
	private static AccountHolder AccountHoldersArray[] = new AccountHolder[0];
	private static CDOffering CDOfferingsArray[] = new CDOffering[0];
	String fileName = "Account_Information.txt";	

	public static void addAccountHolder(AccountHolder accountHolder) {
		AccountHolder[] newAccountHolderArray = new AccountHolder[AccountHoldersArray.length+1];
		for (int i = 0; i < newAccountHolderArray.length-1; i++) {
			newAccountHolderArray[i] = AccountHoldersArray[i];
		}
		AccountHoldersArray = newAccountHolderArray;
		AccountHoldersArray[AccountHoldersArray.length-1] = accountHolder;
	}
	
	public static AccountHolder[] getAccountHolders() {
		return AccountHoldersArray;
	}

	public static CDOffering[] getCDOfferings() {
		return CDOfferingsArray;
	}
	
	public static CDOffering getBestCDOffering(double depositAmount) {
		double best = 0.0; 
		CDOffering bestOffering = null;
		if(CDOfferingsArray == null) {
			return null;
		}
		for(CDOffering offering :  CDOfferingsArray) {
			if(futureValue(depositAmount, offering.getInterestRate(), offering.getTerm()) > best) {
				bestOffering = offering;
				best = futureValue(depositAmount, offering.getInterestRate(), offering.getTerm());
			}
		}
		return bestOffering;
	}

	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		if(CDOfferingsArray == null) {
			return null;
		}
		CDOffering bestOffering = null;
		double best = 0.0; 
		CDOffering secondBestOffering = null;
		
		for(CDOffering offering :  CDOfferingsArray) {
			if(futureValue(depositAmount, offering.getInterestRate(), offering.getTerm()) > best) {
				secondBestOffering = bestOffering;
				bestOffering = offering;
				best = futureValue(depositAmount, offering.getInterestRate(), offering.getTerm());
			}
		}
		return secondBestOffering;
	}

	public static void clearCDOfferings() {
		CDOfferingsArray = null;
	}
	
	public static void setCDOfferings(CDOffering[] offerings) {
		CDOfferingsArray = offerings;
	}

	public static long getNextAccountNumber() {
		return nextAccountNumber;
	}

	public static double totalBalances() {
		double total = 0.0;
		for(AccountHolder accounts : AccountHoldersArray) {
			total += accounts.getCombinedBalance();
		}
		System.out.println("Total aggregate account balance: $" + total);
		return total;
		
	}

	public static double futureValue(double presentValue, double interestRate, int term) {
		double fValue = presentValue*Math.pow(1 + interestRate,  term);
		return fValue;
	}
	
	static boolean readFromFile( String fileName) {
		try {
			FileReader reader = new FileReader(fileName);
			int character;
			
			while((character = reader.read()) !=-1) {
				System.out.print((char)character);
			}
			reader.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	static boolean writeToFile( String fileName) {
		try {
			PrintWriter writer = new PrintWriter(fileName);
			writer.println();//Pass in something
			writer.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return true;
	}
	static AccountHolder[] sortAccountHolders() {
		Arrays.sort(AccountHoldersArray);
		return AccountHoldersArray;
	}
	static void setNextAccountNumber( long accountNumber) {
		nextAccountNumber = accountNumber;
		
	}
	

}