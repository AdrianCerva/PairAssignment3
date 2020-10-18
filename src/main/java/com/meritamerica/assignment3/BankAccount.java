package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccount {
	
	/*
	 * Instance Variables:
	 */
	
	static private double accountBalance;
//	private long masterAccountNumber = 000000000;
	static private long accountNumber;
	static private double interestRate;
	static private Date startDate;
	
	static private SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
	
	/*
	 * Constructors:
	 */
	
	public BankAccount(double balance) {
		this.accountBalance = balance;
		this.accountNumber = AccountHolder.getNewAccountNumber();
	}
	
	public BankAccount(double balance, double interestRate) {
		this.accountBalance = balance;
		this.interestRate = interestRate;
		this.accountNumber = AccountHolder.getNewAccountNumber();
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.accountBalance = balance;
		this.accountNumber = accountNumber;
	}
	
	public BankAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		this.accountNumber = accountNumber;
		this.accountBalance = balance;
		this.accountNumber = accountNumber;
		this.startDate = accountOpenedOn;
	}
	
	/*
	 * Class methods:
	 */
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getBalance() {
		
		return this.accountBalance;
	}
	
	public boolean withdraw(double amount) {
		if(amount <= this.accountBalance) {
			this.accountBalance -= amount;
			return true;
		} else {
			System.out.println("You have insufficient funds to complete this transaction. " +
								"Please call your bank if you feel this information is incorrect.");
			return false;
		}
	}
	
	public boolean deposit(double amount) {
		if(amount <= 0) {
			System.out.println("Cannot add a value of $0 or less!");
			return false;
		} else {
			this.accountBalance += amount;
			System.out.println("Deposited $" + amount + " into your account.");
			return true;
		}
	}
	
	java.util.Date getOpenedOn() {
		return startDate;
	}
	
	public double futureValue(int years) {
		return getBalance() * (Math.pow(1 + getInterestRate(), years));
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	/*
	 * truncate
	 * 
	 * This will truncate a double to the hundredth's place. Good for displaying
	 * money.
	 */
	public double truncateValue(double toTruncate) {		// Optionally truncates the output of the account balance in 3 years.
		
		toTruncate *= 100; 
		int truncatedInt = (int)toTruncate;
		double truncatedDouble = (double)truncatedInt / 100;
		return truncatedDouble;
	}
	
	public BankAccount readFromString(String accountData) throws ParseException {
		String[] accountInfo = accountData.split(",");
		this.accountNumber = Long.valueOf(accountInfo[0]);
		this.accountBalance = Double.valueOf(accountInfo[1]);
		this.interestRate = Double.valueOf(accountInfo[2]);
		this.startDate = formatter.parse(accountInfo[3]);
		
		//return new BankAccount();
		return null;
	}
	
	public String toString() {
		
		return  "Account Balance: $" + getBalance() + "\n" +
				"Account Interest Rate: 0.0001\n" +
				"Account Balance in 3 years: $" + truncateValue(futureValue(3));
	}
	
}
