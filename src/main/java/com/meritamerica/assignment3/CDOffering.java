package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class CDOffering {
	
	private int term;
	private double interestRate;

	public CDOffering(int term, double interestRate){
		this.term = term;
		this.interestRate = interestRate;
	}

	public int getTerm() {
		return term;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
//public static CDOffering readFromString(String cdOfferingData)throws  NumberFormatException {
    	
    	//try {
    		/*String [] holding = cdOfferingData.split(",");
    		//[0] is term, [1] is interestRate, [2]
    		//CDOffering CDOff = new CDOffering(Integer.valueOf(holding[0]),Double.valueOf(holding[1]));
    		int term = Integer.valueOf(holding[0]);
    		double intRate =Double.valueOf(holding[1]);
    		CDOffering CDOff = new CDOffering(term, intRate);
    		return CDOff;*/
    		public static CDOffering readFromString(String cdOfferingDataString) {
    			String[] holding = cdOfferingDataString.split(",");
    			int term = Integer.parseInt(holding[0]);
    			double interestRate = Double.parseDouble(holding[1]);
    			
    			return new CDOffering(term, interestRate);
    		}
    		
    	
    	/*}
    	catch(NumberFormatException e) {
    		e.printStackTrace();
    		return null;
    	}*/
    	
		
    //}

public String writeToString() {
	StringBuilder cdOfferingData = new StringBuilder();
	cdOfferingData.append(term).append(",");
	cdOfferingData.append(interestRate);
	return cdOfferingData.toString(); 
}

}