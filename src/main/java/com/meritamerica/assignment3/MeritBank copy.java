package com.meritamerica.assignment3;

class MeritBank {
	
	private static long nextAccountNumber;
	private static AccountHolder AccountHoldersArray[] = new AccountHolder[0];
	private static CDOffering CDOfferingsArray[] = new CDOffering[0];
		

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
		return nextAccountNumber += 1;
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
	

}