package com.meritamerica.assignment3;

//import com.meritamerica.assignment3.AccountHolder;
//import com.meritamerica.assignment3.CDOffering;
import com.meritamerica.assignment3.MeritBank;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		System.out.println("done");
	}
}