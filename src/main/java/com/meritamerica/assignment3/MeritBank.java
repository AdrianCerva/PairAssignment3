package com.meritamerica.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

//import java.util.Arrays;
//import java.util.Random;

public class MeritBank {

	static AccountHolder[] accountHolders = new AccountHolder[0];
	static CDOffering[] cdOfferings = new CDOffering[0];
	static long nextAccountNumber = 0;

	/*
	 * Class methods:
	 */
	static void addAccountHolder(AccountHolder accountHolder) {

		AccountHolder[] newAccountHolders = new AccountHolder[accountHolders.length + 1];
		int i = 0;
		for (i = 0; i < accountHolders.length; i++) {
			newAccountHolders[i] = accountHolders[i];
		}
		newAccountHolders[i] = accountHolder;
		accountHolders = newAccountHolders;
	}

	static AccountHolder[] getAccountHolders() {
		return accountHolders;
	}

	static CDOffering[] getCDOfferings() {
		//System.out.println(cdOfferings.length);
		return cdOfferings;
	}

	static void setCDOfferings(CDOffering[] offerings) {
		cdOfferings = offerings;
	}

	static CDOffering getBestCDOffering(double depositAmount) {
		// double highestAmount = 0;
		// for (int i = 0; i < cdOfferings.length; i++) {
		// if (cdOfferings.) {
		//
		// }
		// }
		return null;
	}

	static CDOffering getSecondBestCDOffering(double depositAmount) {
		// double secondHighestAmount = 0;
		return null;
	}

	static void clearCDOfferings() {
		cdOfferings = null;
	}

	static long getNextAccountNumber() {
		return nextAccountNumber++;
	}

	static double totalBalances() {
		double total = 0;
		for (int i = 0; i < accountHolders.length; i++) {
			total += accountHolders[i].getCombinedBalance();
		}
		return total;
	}

	static boolean readFromFile(String fileName) throws NumberFormatException, ParseException {
		// String tempLine = "";

		try {
			File textFile = new File(fileName);
			FileReader reader = new FileReader(textFile);
			BufferedReader bufferedReader = new BufferedReader(reader);

			// Set the next available account number:
			setNextAccountNumber(Integer.valueOf(bufferedReader.readLine()));

			CDOffering[] newOfferings = new CDOffering[Integer.valueOf(bufferedReader.readLine())];

			// Make x amount of CDofferings:
			for (int i = 0; i < newOfferings.length; i++) {
				newOfferings[i] = CDOffering.readFromString(bufferedReader.readLine());
			}

			// Make x amount of AccountHolders:
			for (int i = 0; i < Integer.valueOf(bufferedReader.readLine()); i++) {
				AccountHolder.readFromString(bufferedReader.readLine());

				// Read x amount of checking accounts:

				for (int j = 0; j < Integer.valueOf(bufferedReader.readLine()); j++) {
					CheckingAccount.readFromString(bufferedReader.readLine());
				}

				// Read x amount of savings accounts:
				for (int k = 0; k < Integer.valueOf(bufferedReader.readLine()); k++) {
					SavingsAccount.readFromString(bufferedReader.readLine());
				}

				// Read x amount of cd accounts:
				for (int l = 0; l < Integer.valueOf(bufferedReader.readLine()); l++) {
					CDAccount.readFromString(bufferedReader.readLine());
				}

			}

			// Close the reader:
			reader.close();
			return true;
			
		} catch (IOException e) {
			System.out.println("File was not found.");
			return false;
		} catch (ParseException e) {
			// throw new java.io.IOException();
			System.out.println("IO error.");
			return false;
		} catch (NumberFormatException e) {
			//throw new java.lang.NumberFormatException();
			return true;
		}
	}

	static boolean writeToFile(String fileName) {
		try {
			FileWriter fr = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fr);
			
			bw.write(String.valueOf(nextAccountNumber));
			bw.newLine();
			bw.write(String.valueOf(cdOfferings.length));
			bw.newLine();
			for(int i = 0; i < cdOfferings.length; i++) {
				bw.write(cdOfferings[i].writeToString());
				bw.newLine();
			}
			bw.write(String.valueOf(accountHolders.length));
			bw.newLine();
			for(int i = 0; i < accountHolders.length; i++) {
				bw.write(accountHolders[i].writeToString());
				bw.newLine();
				bw.write(accountHolders[i].getNumberOfCheckingAccounts());
				for(int j = 0; j < accountHolders[i].getNumberOfCheckingAccounts();j++) {
					bw.write(String.valueOf(accountHolders[i].getCheckingAccounts()[j].writeToString()));
					bw.newLine();
				}
				for(int k = 0; k < accountHolders[i].getNumberOfSavingsAccounts();k++) {
					bw.write(String.valueOf(accountHolders[i].getSavingsAccounts()[k].writeToString()));
					bw.newLine();
				}
				for(int g = 0; g < accountHolders[i].getNumberOfCDAccounts();g++) {
					bw.write(String.valueOf(accountHolders[i].getCDAccounts()[g].writeToString()));
					bw.newLine();
				}
			}
			bw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
		
	}

	static AccountHolder[] sortAccountHolders() {
		// sort the accountHolders
		return null;
	}

	static void setNextAccountNumber(long newAccountNumber) {
		nextAccountNumber = newAccountNumber;
	}

}
