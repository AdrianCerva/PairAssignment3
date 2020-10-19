package com.meritamerica.assignment3;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SavingsAccount extends BankAccount {

	/*
	 * Class variables:
	 */
	
	static private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	/*
	 * Constructors:
	 */

	public SavingsAccount(double balance) {
		super(balance);
		this.interestRate = 0.01;
	}
	
	public SavingsAccount(double balance, double interestRate) {
		super(balance,interestRate);
	}
	
	public SavingsAccount(long accountNumber, double balance, double interestRate) {
		super(accountNumber,balance,accountNumber);
	}
	
	public SavingsAccount(long accountNumber, double balance, double interestRate, java.util.Date accountOpenedOn) {
		super(accountNumber,balance,accountNumber,accountOpenedOn);
	}

	/*
	 * Class methods:
	 */

	public double getInterestRate() {
		return this.interestRate;
	}

	public static SavingsAccount readFromString(String accountData) throws ParseException {
		String[] newAccountHolder = accountData.split(",");
		java.util.Date startDate = formatter.parse(newAccountHolder[3]);

		return new SavingsAccount(Long.parseLong(newAccountHolder[0]),
				Double.parseDouble(newAccountHolder[1]),
				Double.parseDouble(newAccountHolder[2]),
				startDate);
	}

}