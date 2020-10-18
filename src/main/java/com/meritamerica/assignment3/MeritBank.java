package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//import java.util.Arrays;
//import java.util.Random;

public class MeritBank {

	static AccountHolder[] accountHolders = new AccountHolder[0];
	static CDOffering[] cdOfferings = new CDOffering[0];
	static long masterAccountNumber = 000000000;
/*
 * Class methods:
 */

	static void addAccountHolder(AccountHolder accountHolder) {

		AccountHolder[] newAccountHolders = new AccountHolder[accountHolders.length + 1];
		int i = 0;
		for (i = 0; i < accountHolders.length; i++) {
			newAccountHolders[i] = accountHolders[i];
			System.out.println("Inside for loop.");
		}
		newAccountHolders[i] = accountHolder;
		accountHolders = newAccountHolders;
	}

	static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}

	static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}

	static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = offerings;
	}
	

	static CDOffering getBestCDOffering(double depositAmount) {
		//double highestAmount = 0;
		//for (int i = 0; i < cdOfferings.length; i++) {
		//	if (cdOfferings.) {
		//		
		//	}
		//}
		return null;
	}

	static CDOffering getSecondBestCDOffering(double depositAmount) {
		//double secondHighestAmount = 0;
		return null;
	}

	
	static void clearCDOfferings() {
		cdOfferings = null;
	}
	

	
	static long getNextAccountNumber() {
		return masterAccountNumber++;
	}
	
	static double totalBalances() {
		double total = 0;
		for(int i = 0; i < accountHolders.length;i++) {
			total += accountHolders[i].getCombinedBalance();
		}
		return total;
	}
	
	//static double futureValue(double presentValue, 
	//		double interestRate, int term) {
		
	//}
	
	static boolean readFromFile(String fileName) {
		String tempLine;

		try {
			File textFile = new File(fileName);
			FileReader reader = new FileReader(textFile);
			BufferedReader bufferedReader = new BufferedReader(reader);

			while ((tempLine = bufferedReader.readLine()) != null) {
				
				
			}
			// Close the reader:
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File was not found.");
		} catch (IOException e) {
			System.out.println("Input/output exception.");
		}
		
		return false;
	}
	
	static boolean writeToFile() {
		return false;
	}
	
	static AccountHolder[] sortAccountHolders() {
		// sort the accountHolders
		return null;
	}
	
	static void setNextAccountNumber(long nextAccountNumber) {
		masterAccountNumber = nextAccountNumber;
	}
	
}
